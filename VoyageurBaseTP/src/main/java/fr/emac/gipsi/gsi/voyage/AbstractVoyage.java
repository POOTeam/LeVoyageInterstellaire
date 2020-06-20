/**
 * 
 */
package fr.emac.gipsi.gsi.voyage;

import java.util.ArrayList;

import fr.emac.gipsi.gsi.gui.InterfaceSimulation;
import fr.emac.gipsi.gsi.screen.Screen;
import fr.emac.gipsi.gsi.screen.VisualRectangle;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;

/**
 * @author truptil
 *
 */
public abstract class AbstractVoyage {

	protected ArrayList<Planete> listPlanete = new ArrayList<Planete>();
	private AbstractVoyageur simulatedvoyageur;
	private AbstractVoyageur realVoyager;
	private Screen ecran;
	private InterfaceSimulation visualisationAnimation;



	/**
	 * @param simulatedVoyageur 
	 * 
	 */
	public AbstractVoyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
		this.listPlanete=listPlanete;
		ecran = chemin();
		visualisationAnimation = new InterfaceSimulation(this);
		this.simulatedvoyageur = simulatedVoyageur;
	}

	

	public AbstractVoyage(ArrayList<Planete> listPlanete,AbstractVoyageur simulatedVoyageur, AbstractVoyageur realVoyager) {
		this(listPlanete,simulatedVoyageur);
		this.realVoyager= realVoyager;

	}


	public abstract int showFromPlanete(Planete p);
	public abstract int showAll();
	public abstract void lancement();
	public abstract void lancementSimuler();


	public void simulation(boolean voyageurReel){
		afficheEcran();
		if(!voyageurReel){
			lancementSimuler();
		}else{
			lancement();
		}
	}

	
	
	public void afficheEcran(){
		//on reinitialise
		for(VisualRectangle rect:ecran.getRectangles()){
			rect.setNomCouleur("Tan");
		}

		for(Planete at : listPlanete ){
			for(int i = -at.getRayon(); i<at.getRayon()+1; i++){
				for(int j = -at.getRayon(); j<at.getRayon()+1; j++){
					ecran.setColorByXY(at.getPos().getX()+i, at.getPos().getY()+j, at.getColorName());
				}}}

		ecran.setColorByXY(simulatedvoyageur.getPosTete().getX(), simulatedvoyageur.getPosTete().getY(), "Aqua");
		ecran.setColorByXY(simulatedvoyageur.getPosBody().getX(), simulatedvoyageur.getPosBody().getY(), "Black");

		if(!visualisationAnimation.isVisible()){
			visualisationAnimation.setVisible(true);
		}
		visualisationAnimation.changeEcran(ecran);

	}

	public void wait(int timems){
		try {
			Thread.sleep(timems);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Screen chemin() {
			Screen chemin = new Screen("chemin");
			chemin.setColMax(19);
			chemin.setLigMax(19);
			chemin.getRectangles().add(new VisualRectangle(0,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(0,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(1,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(2,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(3,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(4,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(5,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(6,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(7,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(8,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(9,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(10,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(11,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(12,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(13,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(14,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(15,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(16,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(17,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(18,19,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,0,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,1,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,2,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,3,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,4,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,5,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,6,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,7,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,8,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,9,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,10,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,11,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,12,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,13,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,14,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,15,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,16,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,17,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,18,"Tan"));
			chemin.getRectangles().add(new VisualRectangle(19,19,"Tan"));
			return chemin;
			}
	

	/**
	 * @return the listPlanete
	 */
	public ArrayList<Planete> getListPlanete() {
		return listPlanete;
	}


	/**
	 * @return the ecran
	 */
	public Screen getEcran() {
		return ecran;
	}

	
	public void launch() {
		simulation(true);
		
	}



	public void simulation() {
		simulation(false);
	}

	/**
	 * @return the simulatedvoyageur
	 */
	public AbstractVoyageur getSimulatedvoyageur() {
		return simulatedvoyageur;
	}

	/**
	 * @param simulatedvoyageur the simulatedvoyageur to set
	 */
	public void setSimulatedvoyageur(AbstractVoyageur simulatedvoyageur) {
		this.simulatedvoyageur = simulatedvoyageur;
	}

	/**
	 * @return the realVoyager
	 */
	public AbstractVoyageur getRealVoyager() {
		return realVoyager;
	}

	/**
	 * @param realVoyager the realVoyager to set
	 */
	public void setRealVoyager(AbstractVoyageur realVoyager) {
		this.realVoyager = realVoyager;
	}

}
