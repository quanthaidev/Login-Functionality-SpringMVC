package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//Bắt buộc phải tạo Mapper implements từ RowMapper để ghi đè lên method mapRow bên dưới.
public class StudentMapper implements RowMapper<Student> {
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		
		student.setUserMail(rs.getString("user_mail"));
		student.setPassword(rs.getString("password"));

		
		return student;
	}

}
