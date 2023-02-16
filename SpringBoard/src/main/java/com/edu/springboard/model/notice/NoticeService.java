package com.edu.springboard.model.notice;

import java.util.List;

import com.edu.springboard.domain.Notice;

public interface NoticeService {
	public List selectAll();
	public Notice detail(int notice_idx);
	public void regist(Notice notice);
	public void update(Notice notice);
	public void delete(int notice_idx);
}
