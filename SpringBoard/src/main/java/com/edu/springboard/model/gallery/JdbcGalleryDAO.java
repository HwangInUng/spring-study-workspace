package com.edu.springboard.model.gallery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.GalleryException;

@Repository
public class JdbcGalleryDAO implements GalleryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List selectAll() {

		List list = jdbcTemplate.query("select * from gallery order by gallery_idx", new RowMapper<Gallery>() {
			@Override
			public Gallery mapRow(ResultSet rs, int rowNum) throws SQLException {
				Gallery gallery = new Gallery();

				gallery.setGallery_idx(rs.getInt("gallery_idx"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setHit(rs.getInt("hit"));

				List photoList = jdbcTemplate.query("select * from photo where gallery_idx=?",
						new Object[] { gallery.getGallery_idx() }, new RowMapper<Photo>() {
							@Override
							public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
								Photo photo = new Photo();
								photo.setPhoto_idx(rs.getInt("photo_idx"));
								photo.setFilename(rs.getString("filename"));
								return photo;
							}
						});
				gallery.setPhotoList(photoList);

				return gallery;
			}
		});
		return list;
	}

	@Override
	public Gallery selectById(int gallery_idx) {
		String sql = "select * from gallery where gallery_idx=?";
		
		Gallery gallery = (Gallery)jdbcTemplate.queryForObject(sql, new Object[] {gallery_idx},new RowMapper<Gallery>() {
			@Override
			public Gallery mapRow(ResultSet rs, int rowNum) throws SQLException {
				Gallery dto = new Gallery();
				dto.setGallery_idx(rs.getInt("gallery_idx"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setHit(rs.getInt("hit"));
				
				List<Photo> photoList = jdbcTemplate.query("select * from photo where gallery_idx=?",
						new Object[] { gallery_idx }, new RowMapper<Photo>() {
							@Override
							public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
								Photo photo = new Photo();
								photo.setPhoto_idx(rs.getInt("photo_idx"));
								photo.setFilename(rs.getString("filename"));
								
								return photo;
							}
						});
				dto.setPhotoList(photoList);
				
				return dto;
			}
		});
		
		return gallery;
	}

	@Override
	public void insert(Gallery gallery) throws GalleryException {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into gallery(gallery_idx, title, writer, content)");
		sb.append(" values(seq_gallery.nextval, ?, ?, ?)");

		int result = jdbcTemplate.update(sb.toString(),
				new Object[] { gallery.getTitle(), gallery.getWriter(), gallery.getContent() });
		
		String sql = "select seq_gallery.currval as gallery_idx from dual";
		
		int gallery_idx = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("gallery_idx");
			};
		});
		gallery.setGallery_idx(gallery_idx);
		
		if (result < 1) {
			throw new GalleryException("등록 실패");
		}
	}

	@Override
	public void update(Gallery gallery) throws GalleryException {
		StringBuilder sb = new StringBuilder();
		sb.append("update gallery set title=?, writer=?, content=?");
		sb.append(" where gallery_idx=?");

		int result = jdbcTemplate.update(sb.toString(),
				new Object[] { gallery.getTitle(), gallery.getWriter(), gallery.getContent(), gallery.getGallery_idx() });
		if (result < 1) {
			throw new GalleryException("수정 실패");
		}
	}

	@Override
	public void delete(int gallery_idx) throws GalleryException {
		StringBuilder sb = new StringBuilder();
		sb.append("delete from gallery where gallery_idx=?");

		int result = jdbcTemplate.update(sb.toString(),
				new Object[] { gallery_idx });
		if (result < 1) {
			throw new GalleryException("수정 실패");
		}
	}

}
