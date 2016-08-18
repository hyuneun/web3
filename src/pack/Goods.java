package pack;

public class Goods {	//1개의 상품정보 저장용 DTO
	private String name;
	private int price;

	public Goods(String name,int price) {
		this.name =name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
