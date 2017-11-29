
package pack;

import java.util.ArrayList;


public class Tri {
	
	
	
	
	public static void Tri_Tas(ArrayList<Integer> t,boolean croissant) {
		
		Construire_Tas(t,croissant);
		System.out.println(t.toString());
		if (croissant == true) 
			for(int i=t.size()-1;i>=1;i--) {
				Tronspos(t, 0, i);
				Entasser_Max(t, 0, i);
				
			}
		else for(int i=t.size()-1;i>=1;i--) {
			Tronspos(t, 0, i);
			Entasser_Min(t, 0, i);
			
		}
	}
	public static void Construire_Tas(ArrayList<Integer> t,boolean croissant) {
		if (croissant == true) {
			for(int i=(t.size()-1)/2;i>=0;i--) {
				Entasser_Max(t, i, t.size());
			}
		}
			
		else {
			for(int i=(t.size()-1)/2;i>=0;i--) {
				Entasser_Min(t, i, t.size());
			}
		}
			
	}
	public static void Entasser_Max(ArrayList<Integer> t, int i, int x) {// strictement inferieur x taill
	int l =Gauche(i);
	int r = Droit(i);
	int max=0;
	//System.out.println("entasser_max");
	if(l<x && t.get(l)>t.get(i)) {
		max=l;
	}else {
		max=i;
	}
	if (r<x && t.get(r)>t.get(max))max=r;
	//System.out.println("i="+i+" l="+l+" r="+r+" max="+max+" x"+x);
	if (max!=i) {
		Tronspos(t, max, i);
		Entasser_Max(t, max, x);
	}
	}
    
    public static void Entasser_Min(ArrayList<Integer> t, int i, int x) {// strictement inferieur x taill
    	int l =Gauche(i);
    	int r = Droit(i);
    	int max;
    	//System.out.println("entasser_max");
    	if(l<x && t.get(l)<t.get(i)) {
    		max=l;
    	}else {
    		max=i;
    	}
    	if (r<x && t.get(r)<t.get(max))max=r;
    	//System.out.println("i="+i+" l="+l+" r="+r+" max="+max+" x"+x);
    	if (max!=i) {
    		Tronspos(t, max, i);
    		Entasser_Min(t, max, x);
    	}
    	}
        
        public static int Droit(int i) {
        	return i*2+2;
        }
        
        public static int Gauche(int i) {
        	return i*2+1;
        }
    //------------------------------------------TRI FUSION------------------------------------------------------------------

    public static void Tri_fusion_R_C(ArrayList<Integer> t, int d, int f)
    {   
        int m;
        if (d<f)
        {    m=(int)(d+f)/2;
            Tri_fusion_R_C(t, d, m);
            Tri_fusion_R_C(t, m+1, f);
            Fusion_C(t,m,d,f);
        }
    }
    
    public static void Tri_fusion_R_D(ArrayList<Integer> t, int d, int f)
    {   
        int m;
        if (d<f)
        {    m=(int)(d+f)/2;
            Tri_fusion_R_D(t, d, m);
            Tri_fusion_R_D(t, m+1, f);
            Fusion_D(t,m,d,f);
        }
    }
    
    public static void Fusion_D(ArrayList<Integer> t, int m, int d, int f)

    {
        int n1=m-d+1,n2=f-m;
                
        ArrayList<Integer> l,r;
        l=new ArrayList<Integer>();
        r=new ArrayList<Integer>();

        for(int i=0;i<n1;i++)
        { 
            l.add(t.get(d+i));
        }
        for(int j=1;j<=n2;j++)
        {  
            r.add(t.get(m+j));
        }
        
        l.add(Integer.MIN_VALUE);
        r.add(Integer.MIN_VALUE);
        int i=0,j=0;
        
        for(int k=d;k<=f;k++){
            
            if(l.get(i) > r.get(j)){
                t.set(k, l.get(i));
                i++;
            }else{ 
                t.set(k, r.get(j));
                j++;
            }
        }
        
    }
    
    public static void Fusion_C(ArrayList<Integer> t, int m, int d, int f)
    {
        int n1=m-d+1,n2=f-m;      
        ArrayList<Integer> l,r;
        l=new ArrayList<Integer>();
        r=new ArrayList<Integer>();

        for(int i=0;i<n1;i++)
        {
            l.add(t.get(d+i)); 
        }
        for(int j=1;j<=n2;j++)//   ------------------------ (<=) -> (<) 
        {
            r.add(t.get(m+j));
        }
        l.add(Integer.MAX_VALUE);
        r.add(Integer.MAX_VALUE);
        
        int i=0,j=0;
        for(int k=d;k<=f;k++){
            
            if(l.get(i) < r.get(j)){
                t.set(k, l.get(i));
                i++;
            }else{ 
                t.set(k, r.get(j));
                j++;
            }
        }
    }
    
    //-------------------------------------------Tri bull---------------------------------------------------------------
    public static void Tri_Bull_D(ArrayList<Integer> t){
        for(int i = 0; i<t.size();i++){
            for(int j = i+1; j<t.size();j++){
                if(t.get(i) < t.get(j))//----------------  <
                    Tri.Tronspos(t,i,j);
            }
        }
    }
    
    public static void Tri_Bull_C(ArrayList<Integer> t){
        for(int i = 0; i<t.size();i++){
            for(int j = i+1; j<t.size();j++){
                if(t.get(i) > t.get(j))//---------------- >
                    Tri.Tronspos(t,i,j);
            }
        }
    }
    
    //i est le premier element et j et le deuxieme i=0 j=1
    public static void Tri_Bull_R_D(ArrayList<Integer> t,int i, int j){
        if(i<t.size() && j<t.size()){
            if(t.get(i) < t.get(j))
                Tronspos(t, i, j);
            Tri_Bull_R_D(t, i, j+1);
            if(i==j-1)
                Tri_Bull_R_D(t, i+1, j+1);
        }
    }
    
    public static void Tri_Bull_R_C(ArrayList<Integer> t,int i, int j){
        if(i<t.size() && j<t.size()){
            if(t.get(i) > t.get(j))
                Tronspos(t, i, j);
            Tri_Bull_R_C(t, i, j+1);
            if(i==j-1)
                Tri_Bull_R_C(t, i+1, j+1);
        }
    }
    
    public static void Tronspos(ArrayList<Integer> t,int i, int j){
        int e;
        e = t.get(i);
        t.set(i, t.get(j));
        t.set(j, e);
        
    }
    
    //------------------------------------------Tri Insertion--------------------------------------------------------
    public static void Tri_Insertion_D(ArrayList<Integer> t) {
    	int j,si;
    	for(int i=1;i<t.size();i++) {
    		j=i-1;
    		si = i;
    		while(j != -1 && t.get(j)<t.get(si)) {
    			Tronspos(t, j, si);
    			j--;
    			si--;
    		}
    	}
    }
    
    public static void Tri_Insertion_C(ArrayList<Integer> t) {
    	int j,si;
    	for(int i=1;i<t.size();i++) {
    		j=i-1;
    		si = i;
    		while(j != -1 && t.get(j)>t.get(si)) {
    			Tronspos(t, j, si);
    			j--;
    			si--;
    		}
    	}
    }
    
    //---------------------------------------------Tri FUSION+INSERTION-----------------------------------------------
    //le 4eme parametre et la taill maximale du tableau pour le tril par insertion 
    public static void Tri_Fusion_Insertion_C(ArrayList<Integer> t,int d,int f,int coefficient) {
    	//le MAX_V et pour verifier si on est entree dans la 1er boucle
    	int m=Integer.MAX_VALUE;
    	//f-d+1 car on commence par 0 et "coefficient" est la taille du tableau
    	if (f-d+1 <= coefficient && d<f) {
    		int j,si;
        	for(int i=d+1;i<=f;i++) {
        		j=i-1;
        		si = i;
        		while(j != (d-1) && t.get(j)>t.get(si)) {
        			Tronspos(t, j, si);
        			j--;
        			si--;
        		}
        	}
    	}else if (d<f && m==Integer.MAX_VALUE){   
    		
    		m=(int)(d+f)/2;
            Tri_Fusion_Insertion_C(t, d, m,coefficient);
            Tri_Fusion_Insertion_C(t, m+1, f,coefficient);
            Fusion_C(t,m,d,f);
        }
    	
    }
    
    public static void Tri_Fusion_Insertion_D(ArrayList<Integer> t,int d,int f,int coefficient) {
    	//le MAX_V et pour verifier si on est entree dans la 1er boucle
    	int m=Integer.MAX_VALUE;
    	//f-d+1 car on commence par 0 et "coefficient" est la taille du tableau
    	//tri insertion
    	if (f-d+1 <= coefficient && d<f) {
    		int j,si;
        	for(int i=d+1;i<=f;i++) {
        		j=i-1;
        		si = i;
        		while(j != (d-1) && t.get(j)<t.get(si)) {
        			Tronspos(t, j, si);
        			j--;
        			si--;
        		}
        	}
        //Tri fusion 
    	}else if (d<f && m==Integer.MAX_VALUE){   
    		
    		m=(int)(d+f)/2;
            Tri_Fusion_Insertion_D(t, d, m,coefficient);
            Tri_Fusion_Insertion_D(t, m+1, f,coefficient);
            Fusion_D(t,m,d,f);
        }
    	
    }
    
    //------------------------------------------------Tri GENERAL-----------------------------------------------------
    
	//croissant == false ==> decroissant
	public static void Tri_Fusion(ArrayList<Integer> t,boolean croissant) {
		if(croissant == true)
			Tri_fusion_R_C(t, 0, t.size()-1);
		else Tri_fusion_R_D(t, 0, t.size()-1);
		
	}
	//croissant == false ==> decroissant ; R == true ==> Recursive 
	public static void Tri_Bull(ArrayList<Integer> t,boolean R,boolean croissant) {
		if(croissant == true && R == true)
			Tri_Bull_R_C(t, 0, 1);
		else if(croissant == false && R == true)  
			Tri_Bull_R_D(t, 0, 1);
		else if (croissant == false) 
			Tri_Bull_D(t);
		else Tri_Bull_C(t);
		
	}
	//croissant == false ==> decroissant
	public static void Tri_Insertion(ArrayList<Integer> t,boolean croissant) {
		if (croissant == true)
			Tri_Insertion_C(t);
		else Tri_Insertion_D(t);
	}
	//croissant == false ==> decroissant
	public static void Tri_Fusion_Insertion(ArrayList<Integer> t,boolean croissant ,int coefficient) {
		if (croissant == true)
			Tri_Fusion_Insertion_C(t, 0, t.size()-1, coefficient);
		else Tri_Fusion_Insertion_D(t, 0, t.size()-1, coefficient);
	}

    
	public static void main (String[] args) {
	    	
	    	ArrayList<Integer> t= new ArrayList<Integer>();
	    	int nbr=10;
	    	long t1,t2,tdif;
	        for(int i = 1 ; i<= nbr; i++){
	            t.add((int)(Math.random()*100));
	        }
	
	        System.out.println("t = "+t.toString());
	        t1=System.currentTimeMillis();
	        
	        //System.out.println("tri Bull Boucle Croissant");Tri_Bull_C(t); //---------OK
	        //System.out.println("tri Bull Boucle Décroissant");Tri_Bull_D(t); //-----------OK
	        //System.out.println("tri Bull Récursif Croissant");Tri_Bull_R_C(t, 0, nbr-1); //-------OK
	        //System.out.println("tri Bull Récursif Décroissant");Tri_Bull_R_D(t, 0, nbr-1); //-------OK	
	        
	        //System.out.println("tri Fusion Récursif Croissant");Tri_fusion_R_C(t, 0, nbr-1); //--------OK
	        //System.out.println("tri Fusion Récursif Décroissant");Tri_fusion_R_D(t, 0, nbr-1); //------OK
	        
	        //System.out.println("tri Insertion Boucle Croissant");Tri_Insertion_C(t); //---------------OK
	        //System.out.println("tri Insertion Boucle Décroissant");Tri_Insertion_D(t);  //---------------OK
	        
	        //System.out.println("tri FusionInsertion Boucle Croissant");Tri_Fusion_Insertion_C(t, 0, nbr-1, 100);  //---------------OK
	        //System.out.println("tri FusionInsertion Boucle Décroissant");Tri_Fusion_Insertion_D(t, 0, nbr-1, 100); //---------------OK
	        
	        //Tri_Fusion_Insertion(t, false, 100);
	        System.out.println("tri tas ");
	        Tri_Tas(t, false);
	        
	        
	        
	        t2=System.currentTimeMillis();
	        System.out.println("t = "+t.toString());
	        tdif=t2-t1;
	        System.out.println("execution time = "+tdif);
	        
	}
    
    
}
