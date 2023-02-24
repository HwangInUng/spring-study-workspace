package com.edu.springshop.domain;

import lombok.Data;

@Data
public class Member {
	private int member_idx;
	private String member_id;
	private String member_pass;
	private String member_name;
	private String email;
	private String addr1;
	private String addr2;
	private String regdate;
}
