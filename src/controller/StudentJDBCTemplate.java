package controller;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

//Class này ghi đè lên StudentDAO. 
public class StudentJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	// Cái này đếm ra số lượng hàng match với điều kiện
	public int countRecord(String email, String password) {
		String SQL = "SELECT count(*) as Count FROM account where user_mail=? and password =?";
		int num = jdbcTemplateObject.queryForInt(SQL, new Object[] { email, password });

		return num;
	}
	

	// Truy vấn lấy ra hàng có id = ?. Sử dụng StudentMapper
	public Student getStudent(String email) {
		// - Sử dụng method getStudent() này phải cẩn thận, vì SQL phải tìm ra được record
		// thi nó mới OK, còn tìm không ra thì nó sẽ báo lỗi
		// - Còn nếu không thì phải đặt điều kiện If, cho check hàm countRecord() nếu = 1 ở trên trước
		// rồi mới thực thi mấy code bên dưới
		String SQL = "select * from account where user_mail=?";
		Student student = jdbcTemplateObject.queryForObject(SQL, new Object[] { email }, new StudentMapper());

		return student;
	}

}
