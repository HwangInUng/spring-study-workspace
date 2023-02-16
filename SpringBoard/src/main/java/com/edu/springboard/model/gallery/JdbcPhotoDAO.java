package com.edu.springboard.model.gallery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.PhotoException;

@Repository
public class JdbcPhotoDAO implements PhotoDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List selectAll() {
		String sql = "select * from photo order by photo_idx desc";
		
		List list = jdbcTemplate.query(sql, new RowMapper<Photo>() {
			@Override
			public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Photo photo = new Photo();
				photo.getGallery().setGallery_idx(rs.getInt("gallery_idx"));
				photo.setPhoto_idx(rs.getInt("photo_idx"));
				photo.setFilename(rs.getString("filename"));
				
				return photo;
			}
		});
		
		return list;
	}

	@Override
	public List selectById(int gallery_idx) {
		String sql = "select * from photo where gallery_idx=?";
		
		List list = jdbcTemplate.query(sql, new Object[] {gallery_idx}, new RowMapper<Photo>() {
			@Override
			public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Photo dto = new Photo();
				dto.getGallery().setGallery_idx(rs.getInt("gallery_idx"));
				dto.setPhoto_idx(rs.getInt("photo_idx"));
				dto.setFilename(rs.getString("filename"));
				
				return dto;
			}
		});
		
		return list;
	}

	@Override
	public void insert(Photo photo) throws PhotoException {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into photo(photo_idx, filename, gallery_idx)");
		sb.append(" values(seq_photo.nextval, ?, ?)");
		
		int result = jdbcTemplate.update(sb.toString(), new Object[] { photo.getFilename(), photo.getGallery().getGallery_idx()});
		if(result < 1) {
			throw new PhotoException("이미지 등록 실패");
		}
	}

	@Override
	public void delete(int gallery_idx) throws PhotoException {
		StringBuilder sb = new StringBuilder();
		sb.append("delete from photo where gallery_idx=?");
		
		int result = jdbcTemplate.update(sb.toString(), new Object[] {gallery_idx});
		if(result < 1) {
			throw new PhotoException("이미지 삭제 실패");
		}
		
	}
}
