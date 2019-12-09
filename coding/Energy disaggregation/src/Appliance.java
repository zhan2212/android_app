import java.util.ArrayList;

public class Appliance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer input = 1127;
		Integer input2 = 3500;
		
		ArrayList<Integer> WM = new ArrayList<Integer>();
		WM.add(500);
		WM.add(375);
		WM.add(250);
		WM.add(125);
		
		ArrayList<Integer> TD = new ArrayList<Integer>();
		TD.add(3000);
		TD.add(2250);
		TD.add(1500);
		TD.add(750);
		
		ArrayList<Integer> DW = new ArrayList<Integer>();
		DW.add(50);
		DW.add(38);
		DW.add(25);
		DW.add(13);
		
		ArrayList<Integer> RFFZ = new ArrayList<Integer>();
		RFFZ.add(130);
		RFFZ.add(98);
		RFFZ.add(65);
		RFFZ.add(33);
		
		ArrayList<Integer> AC = new ArrayList<Integer>();
		AC.add(2500);
		AC.add(1875);
		AC.add(1250);
		AC.add(625);
		
		ArrayList<Integer> EWH = new ArrayList<Integer>();
		EWH.add(2000);
		EWH.add(1500);
		EWH.add(1000);
		EWH.add(500);
		
		ArrayList<Integer> ESH = new ArrayList<Integer>();
		ESH.add(8000);
		ESH.add(6000);
		ESH.add(4000);
		ESH.add(2000);
		
		ArrayList<Integer> WM2 = new ArrayList<Integer>();
		WM2.add(500);
		WM2.add(500);
		WM2.add(500);
		WM2.add(500);
		
		ArrayList<Integer> TD2 = new ArrayList<Integer>();
		TD2.add(3000);
		TD2.add(3000);
		TD2.add(3000);
		TD2.add(3000);
		
		ArrayList<Integer> DW2 = new ArrayList<Integer>();
		DW2.add(500);
		DW2.add(388);
		DW2.add(275);
		DW2.add(163);
		
		ArrayList<Integer> RFFZ2 = new ArrayList<Integer>();
		RFFZ2.add(0);
		RFFZ2.add(33);
		RFFZ2.add(65);
		RFFZ2.add(98);
		
		ArrayList<Integer> AC2 = new ArrayList<Integer>();
		AC2.add(0);
		AC2.add(625);
		AC2.add(1250);
		AC2.add(1875);
		
		ArrayList<Integer> EWH2 = new ArrayList<Integer>();
		EWH2.add(2000);
		EWH2.add(2000);
		EWH2.add(2000);
		EWH2.add(2000);
		
		ArrayList<Integer> ESH2 = new ArrayList<Integer>();
		ESH2.add(0);
		ESH2.add(2000);
		ESH2.add(4000);
		ESH2.add(6000);
		
		ArrayList<Integer> Total2 = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				Total2.add(WM.get(i)+TD.get(j));
				Total2.add(WM.get(i)+DW.get(j));
				Total2.add(WM.get(i)+RFFZ.get(j));
				Total2.add(WM.get(i)+AC.get(j));
				Total2.add(WM.get(i)+EWH.get(j));
				Total2.add(WM.get(i)+ESH.get(j));
				Total2.add(TD.get(i)+DW.get(j));
				Total2.add(TD.get(i)+RFFZ.get(j));
				Total2.add(TD.get(i)+AC.get(j));
				Total2.add(TD.get(i)+EWH.get(j));
				Total2.add(TD.get(i)+ESH.get(j));
				Total2.add(DW.get(i)+RFFZ.get(j));
				Total2.add(DW.get(i)+AC.get(j));
				Total2.add(DW.get(i)+EWH.get(j));
				Total2.add(DW.get(i)+ESH.get(j));
				Total2.add(RFFZ.get(i)+AC.get(j));
				Total2.add(RFFZ.get(i)+EWH.get(j));
				Total2.add(RFFZ.get(i)+ESH.get(j));
				Total2.add(AC.get(i)+EWH.get(j));
				Total2.add(AC.get(i)+ESH.get(j));
				Total2.add(EWH.get(i)+ESH.get(j));
			}
		}
		
		ArrayList<Integer> Total3 = new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				Total3.add(WM2.get(i)+TD2.get(j));
				Total3.add(WM2.get(i)+DW2.get(j));
				Total3.add(WM2.get(i)+RFFZ2.get(j));
				Total3.add(WM2.get(i)+AC2.get(j));
				Total3.add(WM2.get(i)+EWH2.get(j));
				Total3.add(WM2.get(i)+ESH2.get(j));
				Total3.add(TD2.get(i)+DW2.get(j));
				Total3.add(TD2.get(i)+RFFZ2.get(j));
				Total3.add(TD2.get(i)+AC2.get(j));
				Total3.add(TD2.get(i)+EWH2.get(j));
				Total3.add(TD2.get(i)+ESH2.get(j));
				Total3.add(DW2.get(i)+RFFZ2.get(j));
				Total3.add(DW2.get(i)+AC2.get(j));
				Total3.add(DW2.get(i)+EWH2.get(j));
				Total3.add(DW2.get(i)+ESH2.get(j));
				Total3.add(RFFZ2.get(i)+AC2.get(j));
				Total3.add(RFFZ2.get(i)+EWH2.get(j));
				Total3.add(RFFZ2.get(i)+ESH2.get(j));
				Total3.add(AC2.get(i)+EWH2.get(j));
				Total3.add(AC2.get(i)+ESH2.get(j));
				Total3.add(EWH2.get(i)+ESH2.get(j));
			}
		}
		
		
		int res = input+input2;
		int index = 0;
		int app1 = 0;
		int app2 = 0;
		for(int i=0;i<Total2.size();i++){
			if(res>(Math.abs(Total2.get(i)-input))+Math.abs(Total3.get(i)-input2)){
				res = Math.abs(Total2.get(i)-input)+Math.abs(Total3.get(i)-input2);
				index = i;
				app1 = Total2.get(i);
				app2 = Total3.get(i);
			}
		}
		System.out.println(app1);
		System.out.println(app2);
		System.out.println("case:"+((index-(index%21))/21+1));
		if(index%21==0){
			System.out.println("WM+TD"+","+res);
		}
		if(index%21==1){
			System.out.println("WM+DW"+","+res);
		}
		if(index%21==2){
			System.out.println("WM+RFFZ"+","+res);
		}
		if(index%21==3){
			System.out.println("WM+AC"+","+res);
		}
		if(index%21==4){
			System.out.println("WM+EWH"+","+res);
		}
		if(index%21==5){
			System.out.println("WM+ESH"+","+res);
		}
		if(index%21==6){
			System.out.println("TD+DW"+","+res);
		}
		if(index%21==7){
			System.out.println("TD+RFFZ"+","+res);
		}
		if(index%21==8){
			System.out.println("TD+AC"+","+res);
		}
		if(index%21==9){
			System.out.println("TD+EWH"+","+res);
		}
		if(index%21==10){
			System.out.println("TD+ESH"+","+res);
		}
		if(index%21==11){
			System.out.println("DW+RFFZ"+","+res);
		}
		if(index%21==12){
			System.out.println("DW+AC"+","+res);
		}
		if(index%21==13){
			System.out.println("DW+EWH"+","+res);
		}
		if(index%21==14){
			System.out.println("DW+ESH"+","+res);
		}
		if(index%21==15){
			System.out.println("RFFZ+AC"+","+res);
		}
		if(index%21==16){
			System.out.println("RFFZ+EWH"+","+res);
		}
		if(index%21==17){
			System.out.println("RFFZ+ESH"+","+res);
		}
		if(index%21==18){
			System.out.println("AC+EWH"+","+res);
		}
		if(index%21==19){
			System.out.println("AC+ESH"+","+res);
		}
		if(index%21==20){
			System.out.println("EWH+ESH"+","+res);
		}

	}

}
