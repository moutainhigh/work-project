package net.kingsilk.qh.activity.service.service;

import net.kingsilk.qh.activity.domain.Staff;
import net.kingsilk.qh.activity.repo.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class StaffService {

    @Autowired
    private StaffRepo staffRepo;

    public String setSAStaff(String userId, String brandAppId) {
        Staff staff = new Staff();
        staff.setUserId(userId);
        Set<String> set = new LinkedHashSet<>();
        set.add("SA");
        staff.setAuthorities(set);
        staff.setBrandAppId(brandAppId);
        staffRepo.save(staff);
        return staff.getId();
    }
}