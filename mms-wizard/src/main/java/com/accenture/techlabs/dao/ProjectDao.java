package com.accenture.techlabs.dao;

import com.accenture.techlabs.domain.Adapter;
import com.accenture.techlabs.domain.AppComponent;
import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Product;
import com.accenture.techlabs.domain.Project;
import com.accenture.techlabs.domain.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.sql.DataSource;
/**
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author abiel.m.woldu
 *
 */
public class ProjectDao {
	@Autowired
	private DataSource dataSource;
	/**
	 * 
	 */
	public ProjectDao() {
	}
	
	public long insertProjectAndAllRelatedData(Project project) throws SQLException{
		if(project == null ) return -1;
		
		long projectId = -1L;
		Connection conn = null;
		try{
			conn= dataSource.getConnection();
			//STEP 1. Persist to Project table
			projectId = insertProject(project, conn);
			
			//STEP 2. Persist to Product table (use project table's row as foreign key)
			if(project.getProductList()!=null){
				for(Product product: project.getProductList()){
					long productId = insertProduct(product, projectId, conn);
	
					//STEP 3. Persist to Capability table (use product table's row as forign key)
					if(product.getMandatoryCapabilityList() != null){
						for(Capability capability: product.getMandatoryCapabilityList()){
							long capabilityId = insertCapability(capability, "Mandatory", productId, conn);
					
							//STEP 4. Persist to Service table (use capability  table's row as foreign key)
							if(capability.getServiceList()!= null){
								for(Service service: capability.getServiceList()){
									long serviceId = insertService(service, capabilityId, conn);
									
									//STEP 5. Persist to AppComponent table (use service table's row as foriegn key)
									if(service.getAppComponentList() != null){
										for(AppComponent appComponent : service.getAppComponentList()){
											long appComponentId = insertAppComponent(appComponent, serviceId, conn);
										}
									}
									
									//STEP 6. Persist to Adapter table (use service table's row as foreign key)
									if(service.getAdapterList() != null){
										for(Adapter adapter: service.getAdapterList()){
											long adapterId = insertAdapter(adapter, serviceId, conn);
										}
									}
								}
							}
						}
						for(Capability capability: product.getOptionalCapabilityList()){
							long capabilityId = insertCapability(capability, "Optional", productId, conn);
							
							//STEP 4. Persist to Service table (use capability  table's row as foreign key)
							if(capability.getServiceList()!= null){
								for(Service service: capability.getServiceList()){
									long serviceId = insertService(service, capabilityId, conn);
									
									//STEP 5. Persist to AppComponent table (use service table's row as foriegn key)
									if(service.getAppComponentList() != null){
										for(AppComponent appComponent : service.getAppComponentList()){
											long appComponentId = insertAppComponent(appComponent, serviceId, conn);
										}
									}
									
									//STEP 6. Persist to Adapter table (use service table's row as foreign key)
									if(service.getAdapterList() != null){
										for(Adapter adapter: service.getAdapterList()){
											long adapterId = insertAdapter(adapter, serviceId, conn);
										}
									}
								}
							}
						}
					}
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new SQLException();
				}
			}
		}
		
		return projectId;
	}

	public long insertProject(Project project, Connection conn) throws SQLException{
		String query = "INSERT INTO project "
				+ "(projectName, clientName, projectCountry, projectDescription, deliveryCenter, sharedModel, created, modified) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		long key = 0;

		PreparedStatement prepStatement = conn.prepareStatement(query,	Statement.RETURN_GENERATED_KEYS);
		prepStatement.setString(1, project.getProjectName());
		prepStatement.setString(2, project.getClientName());
		prepStatement.setString(3, project.getProjectCountry());
		prepStatement.setString(4, project.getProjectDescription());
		prepStatement.setString(5, project.getDeliveryCenter());
		prepStatement.setString(6, project.getSharedModel());
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlNow = new Date(now.getTime());
		Timestamp time = new Timestamp(sqlNow.getTime());
		prepStatement.setTimestamp(7, time);
		prepStatement.setTimestamp(8, time);
		prepStatement.executeUpdate();
		ResultSet results = prepStatement.getGeneratedKeys();
		if (results.next()) {
			key = results.getInt(1);
		}
		prepStatement.close();

		return key;
	}
	
	public long insertProduct(Product product, long projectId, Connection conn) throws SQLException{
		String query = "INSERT INTO product "
				+ " ( name, uri, projectId, created, modified) "
				+ " VALUES (?, ?, ?, ?, ?)";
		long key = 0;

		PreparedStatement prepStatement = conn.prepareStatement(query,	Statement.RETURN_GENERATED_KEYS);
		prepStatement.setString(1, product.getName());
		prepStatement.setString(2, product.getUri());
		prepStatement.setLong(3, projectId);
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlNow = new Date(now.getTime());
		Timestamp time = new Timestamp(sqlNow.getTime());
		prepStatement.setTimestamp(4, time);
		prepStatement.setTimestamp(5, time);
		prepStatement.executeUpdate();
		ResultSet results = prepStatement.getGeneratedKeys();
		if (results.next()) {
			key = results.getInt(1);
		}
		prepStatement.close();

		return key;
	}
	
	public long insertCapability(Capability capability, String capabilityType , long productId, Connection conn) throws SQLException{
		String query = "INSERT INTO capability "
				+ " (  name, uri, type, productId, created, modified) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		long key = 0;

		PreparedStatement prepStatement = conn.prepareStatement(query,	Statement.RETURN_GENERATED_KEYS);
		prepStatement.setString(1, capability.getName());
		prepStatement.setString(2, capability.getUri());
		prepStatement.setString(3, capabilityType);
		prepStatement.setLong(4, productId);
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlNow = new Date(now.getTime());
		Timestamp time = new Timestamp(sqlNow.getTime());
		prepStatement.setTimestamp(5, time);
		prepStatement.setTimestamp(6, time);
		prepStatement.executeUpdate();
		ResultSet results = prepStatement.getGeneratedKeys();
		if (results.next()) {
			key = results.getInt(1);
		}
		prepStatement.close();

		return key;
	}
	
	public long insertService(Service service, long capabilityId, Connection conn) throws SQLException{
		String query = "INSERT INTO service "
				+ " (   name, uri, capabilityId, created, modified ) "
				+ " VALUES (?, ?, ?, ?, ?)";
		long key = 0;

		PreparedStatement prepStatement = conn.prepareStatement(query,	Statement.RETURN_GENERATED_KEYS);
		prepStatement.setString(1, service.getName());
		prepStatement.setString(2, service.getUri());
		prepStatement.setLong(3, capabilityId);
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlNow = new Date(now.getTime());
		Timestamp time = new Timestamp(sqlNow.getTime());
		prepStatement.setTimestamp(4, time);
		prepStatement.setTimestamp(5, time);
		prepStatement.executeUpdate();
		ResultSet results = prepStatement.getGeneratedKeys();
		if (results.next()) {
			key = results.getInt(1);
		}
		prepStatement.close();

		return key;
	}
	
	public long insertAppComponent(AppComponent appComponent, long serviceId, Connection conn) throws SQLException{
		String query = "INSERT INTO appcomponent "
				+ " (    name, uri, serviceId, created, modified ) "
				+ " VALUES (?, ?, ?, ?, ?)";
		long key = 0;

		PreparedStatement prepStatement = conn.prepareStatement(query,	Statement.RETURN_GENERATED_KEYS);
		prepStatement.setString(1, appComponent.getName());
		prepStatement.setString(2, appComponent.getUri());
		prepStatement.setLong(3, serviceId);
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlNow = new Date(now.getTime());
		Timestamp time = new Timestamp(sqlNow.getTime());
		prepStatement.setTimestamp(4, time);
		prepStatement.setTimestamp(5, time);
		prepStatement.executeUpdate();
		ResultSet results = prepStatement.getGeneratedKeys();
		if (results.next()) {
			key = results.getInt(1);
		}
		prepStatement.close();

		return key;
	}
	
	public long insertAdapter(Adapter adapter, long serviceId, Connection conn) throws SQLException{
		String query = "INSERT INTO appcomponent "
				+ " ( name, uri, serviceId, created, modified ) "
				+ " VALUES (?, ?, ?, ?, ?)";
		long key = 0;

		PreparedStatement prepStatement = conn.prepareStatement(query,	Statement.RETURN_GENERATED_KEYS);
		prepStatement.setString(1, adapter.getName());
		prepStatement.setString(2, adapter.getUri());
		prepStatement.setLong(3, serviceId);
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlNow = new Date(now.getTime());
		Timestamp time = new Timestamp(sqlNow.getTime());
		prepStatement.setTimestamp(4, time);
		prepStatement.setTimestamp(5, time);
		prepStatement.executeUpdate();
		ResultSet results = prepStatement.getGeneratedKeys();
		if (results.next()) {
			key = results.getInt(1);
		}
		prepStatement.close();

		return key;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		System.out.println("Setting dataSource ... injection.");
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
	}

}
