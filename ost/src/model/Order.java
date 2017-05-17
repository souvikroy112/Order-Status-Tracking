package model;

public class Order {
	private String order_date,expected_delivery,acrual_deliver,status;
	private long order_id,unit,total_price,salm_id_order;
	
	public long getSalm_id_order() {
		return salm_id_order;
	}
	public void setSalm_id_order(long salm_id_order) {
		this.salm_id_order = salm_id_order;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getExpected_delivery() {
		return expected_delivery;
	}
	public void setExpected_delivery(String expected_delivery) {
		this.expected_delivery = expected_delivery;
	}
	public String getAcrual_deliver() {
		return acrual_deliver;
	}
	public void setAcrual_deliver(String acrual_deliver) {
		this.acrual_deliver = acrual_deliver;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public long getUnit() {
		return unit;
	}
	public void setUnit(long unit) {
		this.unit = unit;
	}
	public long getTotal_price() {
		return total_price;
	}
	public void setTotal_price(long total_price) {
		this.total_price = total_price;
	}
	

}
