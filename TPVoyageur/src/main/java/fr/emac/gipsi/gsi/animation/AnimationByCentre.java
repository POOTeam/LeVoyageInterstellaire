package fr.emac.gipsi.gsi.animation;

public class AnimationByCentre extends AbstractAnimation {
	
	public AnimationByCentre() {
		
	}

	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt = copyScreen(ecranDeb);
		
		int milieuX = (ecranInt.getLigMax()+1)/2;
		int milieuY = (ecranInt.getColMax()+1)/2;
		
		
		for (int lig = 0; lig < milieuX; lig++) {
			System.out.println("StartAnim");
			this.showScreen(ecranInt);
			for (int col = 0; col < milieuY; col++) {
				ecranInt.updateColorByXY(milieuX+lig,milieuY+col, ecranFin.getColorByXY(lig, col));
			}
			this.wait(400);
		}
		this.showScreen(ecranInt);
	}

}
