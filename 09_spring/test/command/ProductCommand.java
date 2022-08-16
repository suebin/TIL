package command;

public class ProductCommand implements Command {
	@Override
	public void run() {
		System.out.println("상품정보 : 등록중입니다.");
	}
}
