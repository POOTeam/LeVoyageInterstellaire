package fr.emac.gipsi.gsi.animation;

public class AnimationByCentre extends AbstractAnimation {
	
	public AnimationByCentre() {
		
	}

	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt = copyScreen(ecranDeb);
		
		int milieuX = (ecranInt.getLigMax())/2;
		int milieuY = (ecranInt.getColMax())/2;

		
		System.out.println("StartAnim");
		for (int ligBordure = 0; ligBordure < milieuX+1; ligBordure++) {
			this.showScreen(ecranInt);

				for (int lig = 0; lig < ligBordure+1; lig++) {
					ecranInt.updateColorByXY(milieuX + lig, milieuY + ligBordure, ecranFin.getColorByXY(milieuX + lig, milieuY + ligBordure));
					ecranInt.updateColorByXY(milieuX - lig, milieuY + ligBordure, ecranFin.getColorByXY(milieuX - lig, milieuY + ligBordure));
					ecranInt.updateColorByXY(milieuX + lig, milieuY - ligBordure, ecranFin.getColorByXY(milieuX + lig, milieuY - ligBordure));
					ecranInt.updateColorByXY(milieuX - lig, milieuY - ligBordure, ecranFin.getColorByXY(milieuX - lig, milieuY - ligBordure));
				}
				for (int col = 0; col < ligBordure; col++) {
					ecranInt.updateColorByXY(milieuX + ligBordure, milieuY + col, ecranFin.getColorByXY(milieuX + ligBordure, milieuY + col));
					ecranInt.updateColorByXY(milieuX + ligBordure, milieuY - col, ecranFin.getColorByXY(milieuX + ligBordure, milieuY - col));
					ecranInt.updateColorByXY(milieuX - ligBordure, milieuY + col, ecranFin.getColorByXY(milieuX - ligBordure, milieuY + col));
					ecranInt.updateColorByXY(milieuX - ligBordure, milieuY - col, ecranFin.getColorByXY(milieuX - ligBordure, milieuY - col));
				}
				this.wait(200);

		}
		this.showScreen(ecranInt);
	}

}
