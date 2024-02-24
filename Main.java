interface BruceDanner {
    
    int SePresenter();
    int MeetBetty();
    int AvalerSubstance();
    int GetState();

    int ETAT_SAIN = 0;
    int ETAT_CONTAMINE = 1;
    int ETAT_HULK = 2;
}

class BruceSain implements BruceDanner {
    private int etat = ETAT_SAIN;

    @Override
    public int SePresenter() {
        System.out.println("Salut, je suis Bruce Danner et je suis sain");
        return 1;
    }

    @Override
    public int MeetBetty() {
        return 1;
    }

    @Override
    public int AvalerSubstance() {
        etat = ETAT_CONTAMINE;
        return 1;
    }

    @Override
    public int GetState() {
        return this.etat;
    }


}


public class Main
    {
     public static void main(String[] args) 
        {
        BruceDanner bruce1 = new BruceSain();
        bruce1.SePresenter();
        System.out.println("Je suis dans l'état : " + bruce1.GetState());
        }
    }
