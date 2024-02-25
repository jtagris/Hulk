interface BruceDanner {
    
    int SePresenter();
    BruceDanner MeetBetty();
    BruceDanner AvalerSubstance();
    String GetState();

    int ETAT_SAIN = 0;
    int ETAT_CONTAMINE = 1;
    int ETAT_HULK = 2;

    int ETAT_BETTY_ICI = 1;
    int ETAT_BETTY_PAS_LA = 0;
}

class BruceSain implements BruceDanner {
    private String etat = "ETAT_SAIN";

    @Override
    public int SePresenter() {
        System.out.println("Salut, je suis Bruce Danner et je suis sain");
        return 1;
    }

    @Override
    public BruceDanner MeetBetty() {
        return this;
    }

    @Override
    public BruceDanner AvalerSubstance() {
        this.etat = "ETAT_CONTAMINE";
        return new BruceContamine();
    }

    @Override
    public String GetState() {
        return this.etat;
    }
}



class BruceContamine implements BruceDanner
{
    private String etat = "ETAT_CONTAMINE";

    @Override
    public int SePresenter()
        {
            System.out.println("je suis en fuite, je ne peut pas donner mon nom ou alors il faudrait que je vous tue aprés haha");
            return 1;
        }
    
    @Override
    public BruceDanner MeetBetty()
        {
            return new Hulk();
        }

    @Override
    public BruceDanner AvalerSubstance()
        {
            return this;
        }

    @Override
    public String GetState() 
    {
            return this.etat;
    }
}


class Hulk implements BruceDanner
{
    private String etat = "ETAT_HULK";

    @Override
    public int SePresenter()
        {
            System.out.println("GRRRROOOOOOOOOOOOoooooooooo");
            return 1;
        }
    
    @Override
    public BruceDanner MeetBetty()
        {
            return new BruceContamine();
        }

    @Override
    public BruceDanner AvalerSubstance() 
        {
            this.etat = "ETAT_SAIN";
            return new BruceSain();
        }

    @Override
    public String GetState() 
        {
            return this.etat;
        }


}


public class Main
    {
     public static void main(String[] args) 
        {
        BruceDanner bruce1 = new BruceSain();
        System.out.println("##########################################");
        bruce1.SePresenter();
        System.out.println("Je suis dans l'état : " + bruce1.GetState());               //BRUCE EST SAIN 

        bruce1 = bruce1.AvalerSubstance();
        
        System.out.println("##########################################");
       
        bruce1.SePresenter();
        System.out.println("Je suis dans l'état : " + bruce1.GetState());               //BRuCE EST CONTAMINE

        System.out.println("##############################################");

        bruce1 = bruce1.MeetBetty();
        bruce1.SePresenter();
        System.out.println("Je suis dans l'état : " + bruce1.GetState());               //BRuCE EST  

        System.out.println("##############################################");

        bruce1 = bruce1.AvalerSubstance();
        bruce1.SePresenter();
        System.out.println("Je suis dans l'état : " + bruce1.GetState()); 

        System.out.println("################### FIN #######################");


      
        }
    }
