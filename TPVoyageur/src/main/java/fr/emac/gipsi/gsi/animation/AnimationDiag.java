package fr.emac.gipsi.gsi.animation;

public class AnimationDiag extends AbstractAnimation{
	
	public AnimationDiag() {
		
	}

	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt=copyScreen(ecranDeb);
		
		for(int i=0;i<2*ecranInt.getLigMax()+1;i++) {
			for(int j=0;j<i+1;j++) {
				if((i-j<ecranInt.getLigMax()+1)&&(j<ecranInt.getColMax()+1)) {
						ecranInt.updateColorByXY(i-j, j, ecranFin.getColorByXY(i-j, j));
						showScreen(ecranInt);
						wait(100);
					}
				}
		}
		
	}
}
