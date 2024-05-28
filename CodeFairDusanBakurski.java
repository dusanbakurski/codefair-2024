
public class CodeFairDusanBakurski{
	public static void main (String[] args) {
		int rez = 0;
		
		Put A = new Put(5,8);
		A.primerA();
		rez = A.ispuniVodom();
		System.out.println(A);
		System.out.println(rez + "\n");
		
		Put B = new Put(5,8);
		B.primerB();
		rez = B.ispuniVodom();
		System.out.println(B);
		System.out.println(rez);
	}
}

class Put{
	String[][] matrix;
	int x,y;
	
	public Put(int x, int y){
		this.matrix = new String[x][y];
		this.x = x;
		this.y = y;
		
		//Popunjava prazan prostor
		for (int i = 0; i < x; i++){
			for (int j = 0; j < y; j++){
				matrix[i][j] = " ";
			}
		}
	}
	/*
	Trazi slobodan prostor izmedju 2 tecke u svakom redu
	i popunjava ih vodom
	*/
	public int ispuniVodom(){
		int red;
		int y1 = -1, y2 = -1;
		int rez = 0;
		boolean drugi;
		
		for (int i = 0; i < this.x; i++){
			drugi = false;
			red = i;
			for (int j = 0; j < this.y; j++){
				if(matrix[i][j].equals("x")){
					if(drugi == false){
						y1 = j;
						drugi = true;
					} else{
						y2 = j;
						rez += voda(red,y1,y2);
						y1 = j;
					}
				}
			}
		}
		
		return rez;
	}
	
	//Izmedju dve tacke ispunjava vodu u redu x
	public int voda(int x, int y1, int y2){
		int brojac = 0;
		for (int i = y1; i < y2; i++){
			if(matrix[x][i].equals(" ")){
				dodaj(x, i, "~");
				brojac++;
			}
		}
		
		return brojac;
	}
	
	public void primerA(){
		for (int i = 0; i < 5; i++){
			dodaj(i, 0, "x");
		}
		for (int i = 3; i < 5; i++){
			dodaj(i, 1, "x");
		}
		for (int i = 3; i < 5; i++){
			dodaj(i, 2, "x");
		}
		for (int i = 1; i < 5; i++){
			dodaj(i, 3, "x");
		}
		for (int i = 2; i < 5; i++){
			dodaj(i, 4, "x");
		}
		for (int i = 3; i < 5; i++){
			dodaj(i, 5, "x");
		}
		for (int i = 2; i < 5; i++){
			dodaj(i, 6, "x");
		}
		for (int i = 1; i < 5; i++){
			dodaj(i, 7, "x");
		}
		
	}
	
	public void primerB(){
		for (int i = 0; i < 5; i++){
			dodaj(i, 0, "x");
		}
		for (int i = 3; i < 5; i++){
			dodaj(i, 1, "x");
		}
		for (int i = 2; i < 5; i++){
			dodaj(i, 2, "x");
		}
		for (int i = 1; i < 5; i++){
			dodaj(i, 3, "x");
		}
		for (int i = 4; i < 5; i++){
			dodaj(i, 4, "x");
		}
		for (int i = 4; i < 5; i++){
			dodaj(i, 5, "x");
		}
		for (int i = 2; i < 5; i++){
			dodaj(i, 6, "x");
		}
		for (int i = 0; i < 5; i++){
			dodaj(i, 7, "x");
		}
		
	}
	
	public void dodaj(int x, int y, String s){
		if(this.x > x && this.y > y)
			matrix[x][y] = s;
	}
	
	public String toString(){
		String s = "";
		
		for (int i = 0; i < x; i++){
			for (int j = 0; j < y; j++){
				s += "["+matrix[i][j]+"] ";
			}
			s += "\n\n";
		}
		
		return s;
	}
	

}

