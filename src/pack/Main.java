package pack;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
    	ArrayList<Integer> t= new ArrayList<Integer>();
    	int nbr=1000;
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
        
        
        
        
        t2=System.currentTimeMillis();
        System.out.println("t = "+t.toString());
        tdif=t2-t1;
        System.out.println("execution time = "+tdif);
    }
    
}
