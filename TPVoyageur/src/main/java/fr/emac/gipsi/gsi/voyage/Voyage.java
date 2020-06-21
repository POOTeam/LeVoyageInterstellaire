/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import java.util.Random;
import fr.emac.gipsi.gsi.screen.Screen;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;
import fr.emac.gipsi.gsi.ecran.ListScreen;
import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationDiag;
import fr.emac.gipsi.gsi.animation.AnimationByLigne;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.animation.AnimationByCentre;
import fr.emac.gipsi.gsi.animation.AnimationFlash;
import fr.emac.gipsi.gsi.animation.AnimationSerpent;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class Voyage extends AbstractVoyage {

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     */
	
	protected ArrayList<Planete> listPlanete;
	protected AbstractVoyageur simulatedVoyageur;
	protected ArrayList<Planete> listPlanetePhotographie;
	protected ArrayList<Planete> listCulsdeSac;
	protected ArrayList<Planete> listPlaneteCreusee;
	protected ArrayList<Planete> listPlanetePrelevee;
	protected ArrayList<ArrayList<Planete>> listListAccessibilite;
	protected ArrayList<Planete> listPlaneteRoche;
	protected ArrayList<Planete> listPlaneteSol;
<<<<<<< HEAD
	
	public static ArrayList<Integer> listDistance;
	public static ArrayList<ArrayList<Planete>> listChemin;
	

=======
	protected ArrayList<Screen> listScreenSol;
	protected ArrayList<Screen> listScreenRoche;
	protected ArrayList<AbstractAnimation> listAnimation;

	public static ArrayList<Integer> listDistance;
	public static ArrayList<ArrayList<Planete>> listChemin;
	
>>>>>>> 6ad2f22f489c44d6cc79d24285187d745e6136ce
	
	
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
        super(listPlanete, simulatedVoyageur);
        
        this.listPlanete = listPlanete;
        this.simulatedVoyageur = simulatedVoyageur;
        this.listPlanetePhotographie = new ArrayList<Planete> ();
        this.listCulsdeSac = new ArrayList<Planete> ();
    	this.listPlaneteCreusee = new ArrayList<Planete> ();
    	this.listPlanetePrelevee = new ArrayList<Planete> ();
    	this.listListAccessibilite = new ArrayList<ArrayList<Planete>> ();
        this.listPlaneteCreusee = new ArrayList<Planete> ();
        this.listPlanetePrelevee = new ArrayList<Planete> ();
<<<<<<< HEAD
    	this.listPlaneteRoche = new ArrayList<Planete> ();
    	this.listPlaneteSol = new ArrayList<Planete> ();


=======
        this.listScreenSol = new ArrayList<Screen> ();
        this.listScreenRoche = new ArrayList<Screen> ();
        this.listAnimation = new ArrayList<AbstractAnimation> ();
        
        this.listCulsdeSac = new ArrayList<Planete> ();
    	this.listListAccessibilite = new ArrayList<ArrayList<Planete>> ();
    	this.listPlaneteRoche = new ArrayList<Planete> ();
    	this.listPlaneteSol = new ArrayList<Planete> ();
        this.listCulsdeSac = new ArrayList<Planete> ();
    	this.listListAccessibilite = new ArrayList<ArrayList<Planete>> ();
>>>>>>> 6ad2f22f489c44d6cc79d24285187d745e6136ce

    }

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     * @param realVoyager
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur, AbstractVoyageur realVoyager) {
        super(listPlanete, simulatedVoyageur, realVoyager);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showFromPlanete(fr.emac.gipsi.gsi.voyage.Planete)
     */
    @Override
    public int showFromPlanete(Planete p) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showAll()
     */
    @Override
    public int showAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotage()
     */
    @Override
    public void lancement() {
    	this.createListDebutCulsdeSac();
    	this.createListListAccessibilite();
    	this.createListAnimation();
    	
    	this.createListPlaneteRoche();
    	this.createListScreenRoche();
    	this.affecterEchantillonRoche();
    	
    	
    	this.createListPlaneteSol();
    	this.createListScreenSol();
    	this.affecterEchantillonSol();
    	
    	//this.executerAnimationAleatoire(this.getEcran(), this.listPlanete.get(1).getEchantillonSol());

    	
		listDistance = new ArrayList<Integer> ();
		listChemin = new ArrayList<ArrayList<Planete>> ();
		
		this.simulatedVoyageur.getAlreadyVisit().add(trouverPlaneteDepart());
    	
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotageSimuler()
     */
    @Override
    public void lancementSimuler() {
<<<<<<< HEAD


    	
    	this.lancement();
    	this.trouverPlaneteSuivante(listPlanete.get(2));
    	this.parcourirPlanetes();
    	

=======
>>>>>>> 6ad2f22f489c44d6cc79d24285187d745e6136ce
    	
    	Planete planeteActuelle = new Planete();

    	this.lancement();
    	
		planeteActuelle = trouverPlaneteDepart();
    	this.actionsPlanete(planeteActuelle);
    	this.trouverPlaneteSuivante(planeteActuelle);
    	this.parcourirPlanetes();

    	while (testFin() == 0) {
    		System.out.println("Roche");
    		System.out.println(this.simulatedVoyageur.getListEchantillonRoche().size());
    		System.out.println(this.listPlaneteCreusee);
    		System.out.println("Sol");
    		System.out.println(this.simulatedVoyageur.getListEchantillonSol().size());
    		System.out.println(this.listPlanetePrelevee);
    		System.out.println("");

<<<<<<< HEAD
    }

    public void parcourirPlanetes() {

=======


    		planeteActuelle = trouverPlaneteActuelle();
    		   		
    		this.resetListAccessibiliteTotal();
        	this.trouverPlaneteSuivante(planeteActuelle);
        	this.parcourirPlanetes();
        	
    	}
    	
    	System.out.println("J'ai fini Chef !");
    }  	
 
    public Planete trouverPlaneteDepart() {
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	Position positionVoyageur = _simulatedVoyageur.getPos().get(0);
    	Planete planeteActuelle = new Planete();
    	for (int i = 0; i < listPlanete.size(); i++) {
    		Position positionPlanete = listPlanete.get(i).getPos();
    		if ((positionVoyageur.getX() == positionPlanete.getX()) && (positionVoyageur.getY() == positionPlanete.getY())) {
    			planeteActuelle = listPlanete.get(i);
    		}
    	}
    	return planeteActuelle;
    }
    
    public Planete trouverPlaneteActuelle() {
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	Position positionVoyageur = _simulatedVoyageur.getPos().get(1);
    	Planete planeteActuelle = new Planete();
    	for (int i = 0; i < listPlanete.size(); i++) {
    		Position positionPlanete = listPlanete.get(i).getPos();
    		if ((positionVoyageur.getX() == positionPlanete.getX()) && (positionVoyageur.getY() == positionPlanete.getY())) {
    			planeteActuelle = listPlanete.get(i);
    		}
    	}
    	return planeteActuelle;
    }    
    
    public void parcourirPlanetes() {
>>>>>>> 6ad2f22f489c44d6cc79d24285187d745e6136ce
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	ArrayList<Planete> _alreadyVisit = _simulatedVoyageur.getAlreadyVisit();
    	ArrayList<Planete> cheminLePlusCourt = trouverCheminPlusCourt();
    	/* 
    	System.out.println("cheminLePlusCourt");
    	System.out.println(cheminLePlusCourt);
    	System.out.println("");
    	*/
    	
    	int cpt = cheminLePlusCourt.size();
    	if((cheminLePlusCourt.get(cheminLePlusCourt.size()-1).getEchantillonSol()==null)&&(cheminLePlusCourt.get(cheminLePlusCourt.size()-1).getEchantillonRoche()==null)) {
    		cpt -= 1;
    	}
    	for(int i=1;i<cpt;i++) {
    		deplacementPlanete(cheminLePlusCourt.get(i));
    		actionsPlanete(cheminLePlusCourt.get(i));

    	}
		_alreadyVisit.add(cheminLePlusCourt.get(cheminLePlusCourt.size()-1));
    }    

    public void createListScreenSol() {
    	this.listScreenSol = new ArrayList<Screen> ();
    	this.listScreenSol.add(ListScreen.funecire());
    	this.listScreenSol.add(ListScreen.momartik());
    	//this.listScreenSol.add(ListScreen.jirachi());
    	this.listScreenSol.add(ListScreen.tarsal());
    	this.listScreenSol.add(ListScreen.obalie());
    	this.listScreenSol.add(ListScreen.minidraco());
    	this.listScreenSol.add(ListScreen.germinion());
    	this.listScreenSol.add(ListScreen.hericendre());
    	this.listScreenSol.add(ListScreen.carapuce());
    	this.listScreenSol.add(ListScreen.evoli());
    	//this.listScreenSol.add(ListScreen.ectoplasma());
    	//this.listScreenSol.add(ListScreen.dracoloss());
    	this.listScreenSol.add(ListScreen.feunnec());
    	this.listScreenSol.add(ListScreen.gruiki());
    	this.listScreenSol.add(ListScreen.bulbizarre());
    	this.listScreenSol.add(ListScreen.Salameche());
    	this.listScreenSol.add(ListScreen.gobu());
    }
<<<<<<< HEAD

=======
    
    public void createListScreenRoche() {
    	this.listScreenRoche = new ArrayList<Screen> ();
    	this.listScreenRoche.add(ListScreen.loveball());
    	this.listScreenRoche.add(ListScreen.Hyperball());
    	this.listScreenRoche.add(ListScreen.Superball());
    	this.listScreenRoche.add(ListScreen.Masterball());
    	this.listScreenRoche.add(ListScreen.Pokeball());
    }
    
>>>>>>> 6ad2f22f489c44d6cc79d24285187d745e6136ce
    public void createListPlaneteRoche() {
    	for (int i = 0; i < this.listPlanete.size(); i++) {
    		if (!(listPlanete.get(i).getEchantillonRoche() == null)) {
    			this.listPlaneteRoche.add(listPlanete.get(i));
    		}
    	}
    }
    
    public void createListPlaneteSol() {
    	for (int i = 0; i < this.listPlanete.size(); i++) {
    		if (!(listPlanete.get(i).getEchantillonSol() == null)) {
    			this.listPlaneteSol.add(listPlanete.get(i));
    		}
    	}
    }
 
    public void createListAnimation() {
    	this.listAnimation = new ArrayList<AbstractAnimation> ();
    	AbstractAnimation animationCentre = new AnimationByCentre();
    	AbstractAnimation animationColumn = new AnimationByColumn();
    	AbstractAnimation animationLigne = new AnimationByLigne();
    	AbstractAnimation animationDiag = new AnimationDiag();
    	AbstractAnimation animationSerpent = new AnimationSerpent();
    	
    	this.listAnimation.add(animationCentre);
    	
    	this.listAnimation.add(animationColumn);
    	this.listAnimation.add(animationLigne);
    	this.listAnimation.add(animationDiag);
    	this.listAnimation.add(animationSerpent);
    	
    	
    }

    public void actionsPlanete(Planete planeteActuelle) {
    	prendEchantillonRoche(planeteActuelle);
    	prendEchantillonSol(planeteActuelle);
    	prendrePhoto(planeteActuelle);	
    	this.listCulsdeSac.remove(planeteActuelle);
    	if (!(this.simulatedVoyageur.getAlreadyVisit().contains(planeteActuelle))) {
        	this.simulatedVoyageur.getAlreadyVisit().add(planeteActuelle);
    	}
		afficheEcran();
    }
    
    public int testFin() {
    	
    	if ((this.listPlanetePhotographie.size() == this.listPlanete.size()) && (this.listPlaneteCreusee.size() == this.listPlaneteSol.size()) && (this.listPlanetePrelevee.size() == this.listPlaneteRoche.size())) {
    		return 1;
    	}
    	
    	else {
    		return 0;
    	}
    		
    }
    
<<<<<<< HEAD

=======
>>>>>>> 6ad2f22f489c44d6cc79d24285187d745e6136ce
    public ArrayList<Planete> trouverCheminPlusCourt() {
    	int distMin = listDistance.get(0);
    	for(int i=1;i<listDistance.size();i++) {
    		if(distMin>listDistance.get(i)) {
    			distMin = listDistance.get(i);
    		}
    	}
		return listChemin.get(listDistance.indexOf(distMin));
    }

<<<<<<< HEAD



=======
>>>>>>> 6ad2f22f489c44d6cc79d24285187d745e6136ce
    public void trouverPlaneteSuivante(Planete planeteActuelle) {
    	// Fonction qui recherche la prochaine destination du voyageur et le prochain chemin jusqu a cette destination
    	
    	ArrayList<Planete> planetesVoisines = planeteActuelle.getListAccessibilite();
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	ArrayList<Planete> _alreadyVisit = _simulatedVoyageur.getAlreadyVisit();

    	boolean culsdeSacPasLoin = false;
		
		// Si la liste des planetes visitees est vide alors on ajoute la planete actuelle
    	if (_alreadyVisit == null) {
    		_alreadyVisit = new ArrayList<Planete> ();
    		_alreadyVisit.add(planeteActuelle);
    	}
    	
    	// Pour toutes les planetes voisines
    	for (int i = 0 ; i < planetesVoisines.size() ; i++) {
    		// S il y a des culs de sac proche dans la galaxie
    		if (listCulsdeSac != null) {
    			// S il y a un cul de sac qui commence sur la planete actuelle alors on y va (pour eviter les allers retours)
        		if ((culsdeSacPasLoin == false) &&(listCulsdeSac.contains(planetesVoisines.get(i)) && (!(_alreadyVisit.contains(planetesVoisines.get(i)))))) {
        			System.out.println("CdS pas loin Chef !");
        			
        			culsdeSacPasLoin = true;
        			boolean trouverCdS = false;
        			Planete planeteCdS = new Planete();
        			int distanceCdS = 0;
        			int j = 0;
        			ArrayList<Planete> cheminCdS = new ArrayList<Planete> ();
        			cheminCdS.add(planeteActuelle);
        			
        			while (trouverCdS == false) {
        				if (listCulsdeSac.contains(planetesVoisines.get(j))) {
        					trouverCdS = true;
           					planeteCdS = planetesVoisines.get(j);
        					cheminCdS.add(planeteCdS);
        					distanceCdS = calculDistance(planeteActuelle, planeteCdS);
 
        				}
        				j++;
        			}
        			
        			j = 0;
        			
        			while(planeteCdS.getListAccessibilite().size() == 2) {
        				planeteCdS.getListAccessibilite().remove(cheminCdS.get(j));
        				planeteCdS = planeteCdS.getListAccessibilite().get(0);
        				cheminCdS.add(planeteCdS);
        				distanceCdS += calculDistance(planeteCdS, cheminCdS.get(j+1));
        				j++;
        			}
            		listDistance = new ArrayList<Integer> ();
            		listChemin = new ArrayList<ArrayList<Planete>> ();
            		listDistance.add(distanceCdS);
            		listChemin.add(cheminCdS);
        		}
    		}
    	}
    	
    	// S il n y a pas de culs de sac qui commence sur la planete actuelle, on commence la recherche generale
    	if (culsdeSacPasLoin == false) {
			System.out.println("Pas de CdS a l'horizon Chef !");
    		listDistance = new ArrayList<Integer> ();
    		listChemin = new ArrayList<ArrayList<Planete>> ();
    		for (int k = 0; k < planetesVoisines.size(); k++) {
    	    	ArrayList<Planete> cheminEnCours = new ArrayList<Planete> ();
    			cheminEnCours.add(planeteActuelle);
    			cheminEnCours.add(planetesVoisines.get(k));

    			trouverPlanetePlusProche(planetesVoisines.get(k), _alreadyVisit, cheminEnCours,calculDistance(planetesVoisines.get(k), planeteActuelle));
    		}

    	}
    }
    
    public void trouverPlanetePlusProche (Planete planeteActuelle, ArrayList<Planete> alreadyVisit, ArrayList<Planete> cheminEnCours, int distEnCours ) {
    	
    	ArrayList<Planete> planetesVoisines = planeteActuelle.getListAccessibilite();
    	ArrayList<Planete> _listAccessibilite;
    	
    	// Si on a jamais ete sur la planete ou on est en ce moment
    	if (!(alreadyVisit.contains(planeteActuelle))) {
			
    		System.out.println("");
			System.out.println("On est jamais venu ici Chef !");
    		
    		// Creation de la deep copie de cheminEnCours
        	ArrayList<Planete> cheminAAjouter = new ArrayList<Planete>();
        	for (int i = 0; i < cheminEnCours.size(); i++) {
            	cheminAAjouter.add(cheminEnCours.get(i));
        	}
        	
        	// Ajout du chemin et de la distance du chemin a deux variables globales
    		listChemin.add(cheminAAjouter);
    		listDistance.add(distEnCours);
    		
    		// Le voyageur retourne a la planete precedente,
    		// il enleve a distEnCours la distance entre les deux planetes
    		// il supprime la liaison entre les deux planetes
			distEnCours-=calculDistance(planeteActuelle, cheminEnCours.get(cheminEnCours.size()-1));
			cheminEnCours.get(cheminEnCours.size()-1).getListAccessibilite().remove(planeteActuelle);
			cheminEnCours.remove(planeteActuelle);

			resetListAccessibilite(planeteActuelle);
    	}
    	
    	else {  		    		
    		// On enleve les planetes deja sur le parcours de la liste des voisins
    		for (int i = 0; i < cheminEnCours.size(); i++) {
    			planetesVoisines.remove(cheminEnCours.get(i));
    		}
    		// S il reste des voisin a la planete actuelle
    		if (planetesVoisines != null) {
    			// On relance l algo avec un cheminEnCours et une distEnCours modifiee
    			for (int j = 0; j < planetesVoisines.size(); j++) {
    				cheminEnCours.add(planetesVoisines.get(j));
    				distEnCours += calculDistance(planeteActuelle, planetesVoisines.get(j));
    				
    				trouverPlanetePlusProche(planetesVoisines.get(j), alreadyVisit, cheminEnCours, distEnCours);
    			}
    		}
    		// Sinon le voyageur retourne a la planete precedente,
    		// il enleve a distEnCours la distance entre les deux planetes
    		// il supprime la liaison entre les deux planetes
    		// et relance l algo de recherche depuis la planete precedente
    		else {
    			distEnCours-=calculDistance(planeteActuelle, cheminEnCours.get(cheminEnCours.size()-1));
    			cheminEnCours.get(cheminEnCours.size()-1).getListAccessibilite().remove(planeteActuelle);
    			cheminEnCours.remove(planeteActuelle);
    			
    			resetListAccessibilite(planeteActuelle);
			
    			trouverPlanetePlusProche(cheminEnCours.get(cheminEnCours.size()), alreadyVisit, cheminEnCours, distEnCours);
    		}
    	}
    	
    }
    
    public void resetListAccessibiliteTotal() {
    	for (int i = 0; i< this.listPlanete.size(); i++) {
    		resetListAccessibilite(this.listPlanete.get(i));
    	}
    }
    
    public void resetListAccessibilite(Planete planeteActuelle) {
    	planeteActuelle.getListAccessibilite().clear();
    	for (int i = 0; i < listListAccessibilite.get(this.listPlanete.indexOf(planeteActuelle)).size(); i++) {
    		Planete _planete = new Planete ();
    		_planete = listListAccessibilite.get(this.listPlanete.indexOf(planeteActuelle)).get(i);
    		planeteActuelle.getListAccessibilite().add(_planete);
    	}
    }
    
    public void createListListAccessibilite() {
    	// Fonction qui creer une copie des listes d accessibilite de toutes les planetes
    	
    	for (int i = 0; i < this.listPlanete.size(); i++) {
    		ArrayList<Planete> _listAccessibilite = new ArrayList<Planete> ();
    		for (int j = 0; j < this.listPlanete.get(i).getListAccessibilite().size(); j++) {
    			Planete _planete = new Planete ();
    			_planete = this.listPlanete.get(i).getListAccessibilite().get(j);
    			_listAccessibilite.add(_planete);
    		}
    		this.listListAccessibilite.add(_listAccessibilite);
    	}
    }
    
    public void createListDebutCulsdeSac() {
    	// Fonction qui creer une liste de toute les planetes qui se trouvent dans un culs de sac
    	// cad les planetes liees a 2 autres planetes sans boucle (qui se termine par une planete solitaire
    	
    	// Pour toute les planetes de la galaxie
    	for (int i = 0; i < this.listPlanete.size(); i++) {
    		// Si la planete n est accessible que par une planete (fin de culs de sac)
    		if (listPlanete.get(i).getListAccessibilite().size() == 1) {
    			Planete debutCulsdeSac = listPlanete.get(i);
    			Planete voisinProche = debutCulsdeSac.getListAccessibilite().get(0);
    			Planete planetePrecedente = new Planete();
    			
    			// On remonte tout les voisins jusqu a ce qu on trouve une planete avec plus de 2 voisins
    			while(voisinProche.getListAccessibilite().size() == 2) {
    				this.listCulsdeSac.add(debutCulsdeSac);
    				planetePrecedente = debutCulsdeSac;
    				debutCulsdeSac = voisinProche;
    				// Selection du prochain voisin parmis les 2 voisins disponible
    				if (debutCulsdeSac.getListAccessibilite().get(0).getPos() != planetePrecedente.getPos()) {
    					voisinProche = debutCulsdeSac.getListAccessibilite().get(0);
    				}
    				else {
    					voisinProche = debutCulsdeSac.getListAccessibilite().get(1);
    				}
    			}
    			this.listCulsdeSac.add(debutCulsdeSac);
    		}
    	}
    }
    
    public void deplacementPlanete(Planete planete) {
    	// Fonction qui permet de deplacer le voyageur jusqu a une planete donnee
    	
    	int posX = planete.getPos().getX();
    	int posY = planete.getPos().getY();
    	
    	this.deplacementXY(posX, posY);
    	
    }
    
<<<<<<< HEAD

=======
>>>>>>> 6ad2f22f489c44d6cc79d24285187d745e6136ce
    public void deplacementXY(int X, int Y) {
    	// Fonction qui permet de deplacer le voyageur jusqu a des coordonnees X et Y donnees
    	
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	int posBodyX = _simulatedVoyageur.getPosBody().getX();
    	int posBodyY = _simulatedVoyageur.getPosBody().getY();
    	String direction = _simulatedVoyageur.getDirection();
    	
    	int distanceX = X - posBodyX;
    	int distanceY = Y - posBodyY;
    	
    	// On commence les deplacements dans le sens du voyageur pour economiser de l energie (tourner consomme 1)
    	if (direction == "S" || direction == "N") {
    		// Si le voyageur est oriente a l envers par rapport a sa destination
    		if ((direction == "S" && distanceX < 0) || (direction == "N" && distanceX > 0) && distanceX != 0) {
    			// On recule de la distance neccessaire
        		for (int distanceParcourueX = 0 ; distanceParcourueX < Math.abs(distanceX) ; distanceParcourueX++) {
        			_simulatedVoyageur.goBackward();
        			afficheEcran();
        			wait(100);
        		}
    		}
    		// Sinon on avance de la distance neccessaire
    		else if (distanceX !=0){
    			for (int distanceParcourueX = 0 ; distanceParcourueX < Math.abs(distanceX) ; distanceParcourueX++) {
    				_simulatedVoyageur.goForward();
    				afficheEcran();
    				wait(100);
    			}
    		}
    		// Orientation du voyageur dans la bonne direction pour le trajet horizontal
    		if ((distanceY < 0 && direction == "N") || (distanceY > 0 && direction == "S") && distanceY != 0) {
    			_simulatedVoyageur.turnLeft();
    			afficheEcran();
    			wait(100);
    		}
    		else if (distanceY != 0) {
    			_simulatedVoyageur.turnRight();
    			afficheEcran();
    			wait(100);
    		}
    		// Le voyageur avance jusqu a sa destination
    		for (int distanceParcourueY = 0 ; distanceParcourueY < Math.abs(distanceY) ; distanceParcourueY++) {
    			_simulatedVoyageur.goForward();
    			afficheEcran();
    			wait(100);
    		}
    	}
    	
    	// Meme principe mais pour un voyageur qui a une position initiale suivant E (est) ou O (ouest)
    	else {
    		if ((distanceY < 0 && direction == "O") || (distanceY > 0 && direction == "E") && distanceY != 0) {
        		for (int distanceParcourueY = 0 ; distanceParcourueY < Math.abs(distanceY) ; distanceParcourueY++) {
        			_simulatedVoyageur.goForward();
        			afficheEcran();
        			wait(100);
        		}
    		}
    		else if (distanceY !=0){
        		for (int distanceParcourueY = 0 ; distanceParcourueY < Math.abs(distanceY) ; distanceParcourueY++) {
        			_simulatedVoyageur.goBackward();
        			afficheEcran();
        			wait(100);
        		}
    		}
    		
    		if ((distanceX < 0 && direction == "O") || (distanceX > 0 && direction == "E") && distanceX != 0) {
    			_simulatedVoyageur.turnRight();
    			afficheEcran();
    			wait(100);
    		}
    		else if (distanceX != 0) {
    			_simulatedVoyageur.turnLeft();
    			afficheEcran();
    			wait(100);
    		}
    		for (int distanceParcourueX = 0 ; distanceParcourueX < Math.abs(distanceX) ; distanceParcourueX++) {
    			_simulatedVoyageur.goForward();
    			afficheEcran();
    			wait(100);
    		}
    	}
    	System.out.println("On est arrive mon Capitaine !");
    	wait(500);
    }
     
    public void prendrePhoto(Planete planeteActuelle) {
    	// Fonction qui permet depuis une planete de regarder et prendre en photo les planetes alentours
    	// qui ne sont pas deja dans la liste des planetes photographiees
    	
    	ArrayList<Planete> _listVisibilite = planeteActuelle.getListVisibilite();
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	
    	if (!(listPlanetePhotographie.contains(planeteActuelle))) {
    		listPlanetePhotographie.add(planeteActuelle);
    		_simulatedVoyageur.takePicture(planeteActuelle);
			System.out.println("J'ai pris une photo Chef");
    	}
    	
    	// Le voyageur ne peut pas voir d autres planetes depuis sa position actuelle 
		if (_listVisibilite.size() == 0) {
			System.out.println("Je vois rien Chef");
		}
		
		// Si le voyageur n a pas encore pris de photo il prend en photo la planete sur laquelle il se trouve
		else if (listPlanetePhotographie.size() == 0) {
    		listPlanetePhotographie.add(_listVisibilite.get(0));
			System.out.println("J'ai pris une photo Chef");
    	}
		
		// Pour toute les planetes de la liste des planetes photographiees
		for (int j = 0 ; j < listPlanetePhotographie.size() ; j++ ) {
			// Pour toutes les planetes visibles par le voyageur
	    	for (int i = 0; i < _listVisibilite.size(); i++) {
    			// Si la planete n a jamais ete photographiee avant, le voyageur la prend en photo
    	    	if (!(listPlanetePhotographie.contains(_listVisibilite.get(i)))) {
    				_simulatedVoyageur.takePicture(listPlanetePhotographie.get(j));
    				listPlanetePhotographie.add(_listVisibilite.get(i));
    				System.out.println("J'ai pris une photo Chef");
    			}
    		}
    	}
    }

    public void prendEchantillonSol(Planete planeteActuelle) {
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	boolean aCreuse = false;
    	if ((listPlaneteCreusee.size() == 0)&&(planeteActuelle.getEchantillonSol()!=null)) {
    		_simulatedVoyageur.takeEchantillonSol(planeteActuelle);
    		listPlaneteCreusee.add(planeteActuelle);
    		System.out.println("J'ai un bloc de dirt Chef");
    	}
    	if(planeteActuelle.getEchantillonSol()!=null) {
    		if(!(listPlaneteCreusee.contains(planeteActuelle))) {
    			listPlaneteCreusee.add(planeteActuelle);
    			_simulatedVoyageur.takeEchantillonSol(planeteActuelle);
    			System.out.println("J'ai un bloc de dirt Chef");
    			aCreuse = true;
    		}
    	}
    	if (aCreuse == false) {
			System.out.println("Y a pas de sol Chef");
    	}
    }

<<<<<<< HEAD

=======
>>>>>>> 6ad2f22f489c44d6cc79d24285187d745e6136ce
    public void prendEchantillonRoche(Planete planeteActuelle) {
    	AbstractVoyageur _simulatedVoyageur = this.getSimulatedvoyageur();
    	boolean aPreleve = false;
    	if ((listPlanetePrelevee.size() == 0) && (planeteActuelle.getEchantillonRoche()!=null)) {
    		_simulatedVoyageur.takeEchantillonRoche(planeteActuelle);
    		listPlanetePrelevee.add(planeteActuelle);
    		System.out.println("J'ai un caillou Chef");
    	}
    	if(planeteActuelle.getEchantillonRoche()!=null) {
    		if(!(listPlanetePrelevee.contains(planeteActuelle))) {
    			listPlanetePrelevee.add(planeteActuelle);
    			_simulatedVoyageur.takeEchantillonRoche(planeteActuelle);
    			System.out.println("J'ai un caillou Chef");
    			aPreleve = true;
    			}
    		}
    	if (aPreleve = false) {
    		System.out.println("Y a pas de caillou Chef");
    	}
    }
    
    public int calculDistance(Planete planete1, Planete planete2) {
    	int posXplanete1 = planete1.getPos().getX();
    	int posYplanete1 = planete1.getPos().getY();
    	int posXplanete2 = planete2.getPos().getX();
    	int posYplanete2 = planete2.getPos().getY();
    	int distance = Math.abs(posXplanete2-posXplanete1+posYplanete2-posYplanete1);
    	return(distance);
    }

    public void affecterEchantillonSol() {
    	Random rand = new Random();
    	int sizeListScreenSol = this.listScreenSol.size();
    	for (int i = 0; i < this.listPlaneteSol.size(); i++) {
    		int n = rand.nextInt(sizeListScreenSol-1);
    		listPlaneteSol.get(i).setEchantillonSol(listScreenSol.get(n));
    	}
    }
    
    public void affecterEchantillonRoche() {
    	Random rand = new Random();
    	int sizeListScreenRoche = this.listScreenRoche.size();
    	for (int i = 0; i < this.listPlaneteRoche.size(); i++) {
    		int n = rand.nextInt(sizeListScreenRoche-1);
    		listPlaneteRoche.get(i).setEchantillonRoche(listScreenRoche.get(n));
    	}
    }

    
    
    public void executerAnimationAleatoire(Screen ecranDebut, Screen ecranFin) {
    	
    	Random rand = new Random();
    	int n = rand.nextInt(listAnimation.size());
    	
    	AbstractAnimation animation = listAnimation.get(n);
    	
		animation.setEcranDeb(ecranDebut);
		animation.setEcranFin(ecranFin);
		
		animation.runAnimation();

		animation.wait(500);
    	
    }
}

	
