package fr.emac.gipsi.gsi.animation;


import fr.emac.gipsi.gsi.screen.Screen;

public class AnimationByLigne extends AbstractAnimation {


    public AnimationByLigne() {

    }

    @Override
    public void runAnimation() {
        showScreen(ecranDeb);
        ecranInt = copyScreen(ecranDeb);
        for (int lig = 0; lig < ecranInt.getLigMax()+1; lig++) {
            System.out.println("StartAnim");
            for (int col = 0; col < ecranInt.getColMax()+1; col++) {
                ecranInt.updateColorByXY(lig,col, ecranFin.getColorByXY(lig, col));
                this.showScreen(ecranInt);
                this.wait(5);
            }
        }
        this.showScreen(ecranInt);
    }
}