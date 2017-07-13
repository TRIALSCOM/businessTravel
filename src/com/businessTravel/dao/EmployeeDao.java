package com.businessTravel.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.businessTravel.dao.provider.EmployeeProvider;
import com.businessTravel.domain.Employee;
import static com.businessTravel.util.BusinessConstant.*;

import java.util.List;


public interface EmployeeDao {
	
	
	@Select("select * from employee_info where id=#{id} and active_status='"+ACTIVEY+"' ")
	@Results(
			{
			  @Result(id=true,column="id",property="id"),
			  @Result(column="sex",property="sex"),
			  @Result(column="phone",property="phone"),
			  @Result(column="email",property="email"),
			  @Result(column="name",property="name"),
			  @Result(column="password",property="password"),
			  @Result(column="qq_num",property="qqNum"),
			  @Result(column="employee_number",property="employeeNumber"),
			  @Result(column="validate_code" ,property="validateCode"),
			  @Result(column="register_date",property="registerDate"),
			  @Result(column="active_status",property="activeStatus"),
			  @Result(column="real_name",property="realName"),
			  @Result(column="department_id",property="dept",one=@One(
					  select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="role_id",property="roleInfo",one=@One(
					  select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="attachment_id",property="attachment",one=@One(
					  select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			  
			}
			)
	Employee getOneActiveEmployeeById(@Param("id")Integer id);
	
	
	@Select("select * from employee_info where (name=#{loginName} or email=#{loginName} or "
			+ "phone=#{loginName} )and password=#{password}  and active_status='"+ACTIVEY+"' ")
	@Results(
			{
			  @Result(id=true,column="id",property="id"),
			  @Result(column="sex",property="sex"),
			  @Result(column="phone",property="phone"),
			  @Result(column="email",property="email"),
			  @Result(column="name",property="name"),
			  @Result(column="password",property="password"),
			  @Result(column="qq_num",property="qqNum"),
			  @Result(column="employee_number",property="employeeNumber"),
			  @Result(column="validate_code" ,property="validateCode"),
			  @Result(column="register_date",property="registerDate"),
			  @Result(column="active_status",property="activeStatus"),
			  @Result(column="real_name",property="realName"),
			  @Result(column="department_id",property="dept",one=@One(
					  select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="role_id",property="roleInfo",one=@One(
					  select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="attachment_id",property="attachment",one=@One(
					  select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			  
			}
			)
	Employee getOneEmployee(@Param("loginName")String loginName, @Param("password")String password);
	
	
	
	@Select("select * from employee_info where name=#{userName} ")
	@Results(
			{
			  @Result(id=true,column="id",property="id"),
			  @Result(column="sex",property="sex"),
			  @Result(column="phone",property="phone"),
			  @Result(column="email",property="email"),
			  @Result(column="name",property="name"),
			  @Result(column="password",property="password"),
			  @Result(column="qq_num",property="qqNum"),
			  @Result(column="employee_number",property="employeeNumber"),
			  @Result(column="validate_code" ,property="validateCode"),
			  @Result(column="register_date",property="registerDate"),
			  @Result(column="active_status",property="activeStatus"),
			  @Result(column="real_name",property="realName"),
			  @Result(column="department_id",property="dept",one=@One(
					  select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="role_id",property="roleInfo",one=@One(
					  select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="attachment_id",property="attachment",one=@One(
					  select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			  
			}
			)
	Employee getOneByEmployeeByName(@Param("userName")String userName);
	
	
	@Select("select * from employee_info where email=#{email}")
	@Results(
			{
			  @Result(id=true,column="id",property="id"),
			  @Result(column="sex",property="sex"),
			  @Result(column="phone",property="phone"),
			  @Result(column="email",property="email"),
			  @Result(column="name",property="name"),
			  @Result(column="password",property="password"),
			  @Result(column="qq_num",property="qqNum"),
			  @Result(column="employee_number",property="employeeNumber"),
			  @Result(column="validate_code" ,property="validateCode"),
			  @Result(column="register_date",property="registerDate"),
			  @Result(column="active_status",property="activeStatus"),
			  @Result(column="real_name",property="realName"),
			  @Result(column="department_id",property="dept",one=@One(
					  select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="role_id",property="roleInfo",one=@One(
					  select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="attachment_id",property="attachment",one=@One(
					  select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			  
			}
			)
	   Employee getOneByEmail(String email);
	
	

	@Select("select * from employee_info where id=#{id}")
	@Results(
			{
			  @Result(id=true,column="id",property="id"),
			  @Result(column="sex",property="sex"),
			  @Result(column="phone",property="phone"),
			  @Result(column="email",property="email"),
			  @Result(column="name",property="name"),
			  @Result(column="password",property="password"),
			  @Result(column="qq_num",property="qqNum"),
			  @Result(column="employee_number",property="employeeNumber"),
			  @Result(column="validate_code" ,property="validateCode"),
			  @Result(column="register_date",property="registerDate"),
			  @Result(column="active_status",property="activeStatus"),
			  @Result(column="real_name",property="realName"),
			  @Result(column="department_id",property="dept",one=@One(
					  select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="role_id",property="roleInfo",one=@One(
					  select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="attachment_id",property="attachment",one=@One(
					  select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			  
			}
			)
	 Employee getOneById(@Param("id")Integer id);
	
	
	
	
	@Select("select * from employee_info ")
	@Results(
			{
			  @Result(id=true,column="id",property="id"),
			  @Result(column="sex",property="sex"),
			  @Result(column="phone",property="phone"),
			  @Result(column="email",property="email"),
			  @Result(column="name",property="name"),
			  @Result(column="password",property="password"),
			  @Result(column="qq_num",property="qqNum"),
			  @Result(column="validate_code" ,property="validateCode"),
			  @Result(column="register_date",property="registerDate"),
			  @Result(column="active_status",property="activeStatus"),
			  @Result(column="real_name",property="realName"),
			  @Result(column="employee_number",property="employeeNumber"),
			  @Result(column="department_id",property="dept",one=@One(
					  select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="role_id",property="roleInfo",one=@One(
					  select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="attachment_id",property="attachment",one=@One(
					  select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			  
			}
			)
	List<Employee>getAllEmployee();
	
	

	
	
	
	@Select("select count(*) from employee_info")
	 Integer getEmployeeCount();
	
	
	@UpdateProvider(type=EmployeeProvider.class,method="updateEmployee")
	void updateEmployee(Employee employee);
	
	

	@InsertProvider(type=EmployeeProvider.class,method="insertIntoEmployee")
	void insertEmployee(Employee employee);
  
	
	//得到处于未激活状态的员工
	@Select("select * from employee_info where active_status='"+ACTIVEN+"' ")
	@Results(
			{
			  @Result(id=true,column="id",property="id"),
			  @Result(column="sex",property="sex"),
			  @Result(column="phone",property="phone"),
			  @Result(column="email",property="email"),
			  @Result(column="name",property="name"),
			  @Result(column="password",property="password"),
			  @Result(column="qq_num",property="qqNum"),
			  @Result(column="validate_code" ,property="validateCode"),
			  @Result(column="register_date",property="registerDate"),
			  @Result(column="active_status",property="activeStatus"),
			  @Result(column="real_name",property="realName"),
			  @Result(column="employee_number",property="employeeNumber"),
			  @Result(column="department_id",property="dept",one=@One(
					  select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="role_id",property="roleInfo",one=@One(
					  select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),
			  @Result(column="attachment_id",property="attachment",one=@One(
					  select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			  
			}
			)
	List<Employee> selectEmployeeActiveN();
	
	
}
