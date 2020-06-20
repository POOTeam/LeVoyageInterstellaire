/**
 * 
 */
package fr.emac.gipsi.gsi.launch;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationByCentre;
import fr.emac.gipsi.gsi.animation.AnimationByLigne;
import fr.emac.gipsi.gsi.animation.AnimationDiag;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.animation.AnimationFlash;
import fr.emac.gipsi.gsi.animation.AnimationSerpent;
import fr.emac.gipsi.gsi.ecran.ListScreen;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class LaunchAnimation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AbstractAnimation aa = new AnimationDiag();
		aa.setEcranDeb(ListScreen.germinion());
		aa.setEcranFin(ListScreen.gobu());
		
		aa.runAnimation();

		aa.wait(1000);
		
		AbstractAnimation ab = new AnimationByCentre();
		
		ab.setEcranDeb(ListScreen.gobu());
		ab.setEcranFin(ListScreen.germinion());
		
		ab.runAnimation();
		
		ab.wait(1000);

	}

}
