package com.htv.xgate.model.dto.user;

import java.util.List;

public record UserInfo(List<Long> id,List<String> username, List<String> fullName) {
}
