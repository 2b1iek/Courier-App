package com.courier.dao;

import com.courier.model.Courier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourierDao {

    private JdbcTemplate jdbcTemplate;

    // Getter & Setter for dependency injection
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Insert a new courier record into the database.
     */
    public void saveCourier(Courier cou) {
        String sql = "INSERT INTO courier (name, contact, region, itemsDelivered, visitDate, hours) VALUES (?, ?, ?, ?, ?, ?)";
        int status = jdbcTemplate.update(sql,
                cou.getName(),
                cou.getContact(),
                cou.getRegion(),
                cou.getItemsDelivered(),
                cou.getVisitDate(),
                cou.getHours());

        if (status > 0) {
            System.out.println("✅ Courier record saved successfully.");
        }
    }

    /**
     * Update an existing courier record.
     */
    public void updateCourier(Courier updated, int courierId) {
        String sql = "UPDATE courier SET name=?, contact=?, region=?, itemsDelivered=?, visitDate=?, hours=? WHERE courier_id=?";
        int status = jdbcTemplate.update(sql,
                updated.getName(),
                updated.getContact(),
                updated.getRegion(),
                updated.getItemsDelivered(),
                updated.getVisitDate(),
                updated.getHours(),
                courierId);

        if (status > 0) {
            System.out.println("✅ Courier record updated successfully.");
        }
    }

    /**
     * Delete a courier record by ID.
     */
    public void deleteCourier(int courierId) {
        String sql = "DELETE FROM courier WHERE courier_id=?";
        int status = jdbcTemplate.update(sql, courierId);
        if (status > 0) {
            System.out.println("🗑️ Courier record deleted successfully.");
        }
    }

    /**
     * Retrieve all courier records.
     */
    public List<Courier> getAllCouriers() {
        String sql = "SELECT * FROM courier";
        return jdbcTemplate.query(sql, new CourierRowMapper());
    }

    /**
     * Retrieve a courier by ID (single object).
     */
    public Courier getCourierById(int courierId) {
        String sql = "SELECT * FROM courier WHERE courier_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{courierId}, new CourierRowMapper());
    }

    /**
     * Retrieve couriers by ID (returns a list for flexibility).
     */
    public List<Courier> getCouriersById(int courierId) {
        String sql = "SELECT * FROM courier WHERE courier_id=?";
        return jdbcTemplate.query(sql, new Object[]{courierId}, new CourierRowMapper());
    }

    /**
     * Inner static class for Row Mapping
     */
    private static class CourierRowMapper implements RowMapper<Courier> {
        @Override
        public Courier mapRow(ResultSet rs, int rowNum) throws SQLException {
            Courier c = new Courier();
            c.setCourierId(rs.getInt("courier_id"));
            c.setName(rs.getString("name"));
            c.setContact(rs.getString("contact"));
            c.setRegion(rs.getString("region"));
            c.setItemsDelivered(rs.getInt("itemsDelivered"));
            c.setVisitDate(rs.getString("visitDate"));
            c.setHours(rs.getDouble("hours"));
            return c;
        }
    }
}
