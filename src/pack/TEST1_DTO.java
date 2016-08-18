package pack;

public class TEST1_DTO {
	private String bun;
	private String name;
	private String kor;
	private String eng;
	
	public TEST1_DTO(String bun,String name,String kor,String eng) {
		this.bun = bun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	public String getBun() {
		return bun;
	}
	 
	public String getName() {
		return name;
	}
	
	public String getKor() {
		return kor;
	}
	
	public String getEng() {
		return eng;
	}
}
