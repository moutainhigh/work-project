package net.kingsilk.qh.agency.admin.resource.addr

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import net.kingsilk.qh.agency.admin.api.UniResp
import net.kingsilk.qh.agency.admin.api.addr.AddrApi
import net.kingsilk.qh.agency.admin.api.addr.dto.*
import net.kingsilk.qh.agency.admin.resource.addr.convert.AddressConvert
import net.kingsilk.qh.agency.domain.Adc
import net.kingsilk.qh.agency.domain.Address
import net.kingsilk.qh.agency.domain.PartnerStaff
import net.kingsilk.qh.agency.domain.QAddress
import net.kingsilk.qh.agency.repo.AdcRepo
import net.kingsilk.qh.agency.repo.AddressRepo
import net.kingsilk.qh.agency.service.AddrService
import net.kingsilk.qh.agency.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.util.Assert

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

import static com.querydsl.core.types.dsl.Expressions.allOf

@Path("/addr")
@Component
@Api(
        tags = "addr",
        produces = MediaType.APPLICATION_JSON,
        protocols = "http,https",
        description = "地址管理相关API"
)
class AddrResource implements AddrApi {

    @Autowired
    AddrService addrService

    @Autowired
    AddressRepo addressRepo

    @Autowired
    MemberService memberService

    @Autowired
    AddressConvert addressConvert

    @Autowired
    AdcRepo adcRepo

    @ApiOperation(
            value = "获取收货地址列表",
            nickname = "获取收货地址列表",
            notes = "获取收货地址列表")
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    UniResp<AddrListResp> list(AddrListReq req) {
        PartnerStaff partnerStaff = memberService.getCurPartnerStaff()
//        PageRequest pageRequest = new PageRequest(req.curPage, req.pageSize,
//                new Sort(new Sort.Order(Sort.Direction.DESC, "dateCreated")))
        Iterable<Address> address = addressRepo.findAll(
                allOf(
                        QAddress.address.partnerStaff.eq(partnerStaff),
                        QAddress.address.deleted.in([false, null])),
        )
        AddrListResp resp = new AddrListResp()
        resp.recList = new ArrayList()
        address.each { Address it ->
            AddrModel info = addressConvert.addrModelConvert(it)
            resp.recList.add(info)
        }
        return new UniResp<AddrListResp>(status: 200, data: resp)
    }


    @ApiOperation(
            value = "获取收货地址详情",
            nickname = "获取收货地址详情",
            notes = "获取收货地址详情"
    )
    @Path("/detail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    UniResp<AddrModel> detail(@QueryParam(value = "id") String id) {
        Address address = addressRepo.findOne(id)
        Assert.notNull(address, "地址错误")
        AddrModel resp = addressConvert.addrModelConvert(address)
        return new UniResp<AddrModel>(status: 200, data: resp)
    }


    @ApiOperation(
            value = "保存收货地址",
            nickname = "保存收货地址",
            notes = "保存收货地址"
    )
    @Path("/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    UniResp<String> save(AddrSaveReq req) {
        PartnerStaff member = memberService.getCurPartnerStaff()
        Address address = new Address()
        if (req.id) {
            address = addressRepo.findOneByIdAndPartnerStaff(req.id, member)
            Assert.isTrue(!address.deleted, "该地址已删除")
            Assert.notNull(address, "原地址错误")
        }
        Adc adc = adcRepo.findOneByNo(req.adcNo)
        address.adc = adc
        address.street = req.street
        address.receiver = req.receiver
        address.phone = req.phone
        address.memo = req.memo
        address.partnerStaff = member
        address.defaultAddr = false

        //判断是否有默认地址，没有则自动添加
        Address tmpAddr = addressRepo.findOneByPartnerStaffAndIsDefaultAndDeleted(member, false, false)
        if (!tmpAddr) {
            req.isDefault = true
        }

        if (req.isDefault) {
            addrService.updateDefaultAddr(address)
        }
        addressRepo.save(address)
        return new UniResp<String>(status: 200, data: "保存成功")
    }


    @ApiOperation(
            value = "设置默认收货地址",
            nickname = "设置默认收货地址",
            notes = "设置默认收货地址"
    )
    @Path("/setDefault")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    UniResp<String> setDefault(@QueryParam(value = "id") String id) {
        PartnerStaff member = memberService.getCurPartnerStaff()
        Address address = addressRepo.findOneByIdAndPartnerStaff(id, member)
        Assert.isTrue(!address.deleted, "该地址已删除")
        Assert.notNull(address, "未找到收货地址")
        addrService.updateDefaultAddr(address)
        addressRepo.save(address)
        return new UniResp<String>(status: 200, data: "保存成功")
    }


    @ApiOperation(
            value = "搜索adc",
            nickname = "搜索adc",
            notes = "搜索adc"
    )
    @Path("/queryAdc")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    UniResp<AddrQueryAdcResp> queryAdc(@BeanParam AddrQueryAdcReq req) {
        Adc adc = null
        if (req.adc) {
            adc = adcRepo.findOneByNo(req.adc)
        }
        List<Adc> adcList = adcRepo.findAllByParent(adc)
        AddrQueryAdcResp resp = addressConvert.queryAdcRespConvert(adc, adcList)
        return new UniResp<AddrQueryAdcResp>(status: 200, data: resp)
    }


    @ApiOperation(
            value = "删除收货地址",
            nickname = "删除收货地址",
            notes = "删除收货地址"
    )
    @Path("/delete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    UniResp<String> delete(@QueryParam(value = "id") String id) {
        PartnerStaff member = memberService.getCurPartnerStaff()
        Address address = addressRepo.findOneByIdAndPartnerStaff(id, member)
        Assert.notNull(address, "地址错误")
        address.deleted = true
        addressRepo.save(address)
        return new UniResp<String>(status: 200, data: "删除成功")
    }
}
