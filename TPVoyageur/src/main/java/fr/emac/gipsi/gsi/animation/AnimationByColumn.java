/**
 * 
 */
package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

/**
 * @author truptil
 *
 */

public class AnimationByColumn extends AbstractAnimation{
 
	/**
	 * 
	 */
	public AnimationByColumn() {
		
	}

	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt=copyScreen(ecranDeb);
		for(int col=0;col<ecranInt.getColMax()+1;col++){
			for(int lig=0;lig<ecranInt.getLigMax()+1;lig++){
				ecranInt.updateColorByXY(lig, col, ecranFin.getColorByXY(lig,col));
				this.showScreen(ecranInt);
				this.wait(5);
			}			
		}
		this.showScreen(ecranInt);
		
	}

	

}
