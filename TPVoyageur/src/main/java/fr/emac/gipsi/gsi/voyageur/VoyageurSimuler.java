/**
 *
 */
package fr.emac.gipsi.gsi.voyageur;

import fr.emac.gipsi.gsi.voyage.Position;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class VoyageurSimuler extends AbstractVoyageur {

    /**
     *
     */
    public VoyageurSimuler() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#forward()
     */
    @Override
    protected void forward() {
    	
       int posBodyX = this.getPosBody().getX();
       int posBodyY = this.getPosBody().getY();
       int posTeteX = this.getPosTete().getX();
       int posTeteY = this.getPosTete().getY();
       
       // Ajouter des conditions si on est aux limites de l'écran
       
       if (this.direction == "S") {
    		    posBodyX += 1;
    		    posTeteX +=1;
    		    this.setPosBody(new Position(posBodyX, posBodyY));
    		    this.setPosTete(new Position(posTeteX, posTeteY));
       }
       else if (this.direction == "E") {
    		   posBodyY += 1;
    		   posTeteY += 1;
    		   this.setPosBody(new Position(posBodyX, posBodyY));
    		   this.setPosTete(new Position(posTeteX, posTeteY));
       }
       else if (this.direction == "O") {
    		   posBodyY -= 1;
    		   posTeteY -= 1;
    		   this.setPosBody(new Position(posBodyX, posBodyY));
    		   this.setPosTete(new Position(posTeteX, posTeteY));
       }
       else if (this.direction == "N") {
    		    posBodyX -= 1;
    		    posTeteX -=1;
    		    this.setPosBody(new Position(posBodyX, posBodyY));
    		    this.setPosTete(new Position(posTeteX, posTeteY));
       }

    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#backward()
     */
    @Override
    protected void backward() {
        int posBodyX = this.getPosBody().getX();
        int posBodyY = this.getPosBody().getY();
        int posTeteX = this.getPosTete().getX();
        int posTeteY = this.getPosTete().getY();
        
        // Ajouter des conditions si on est aux limites de l'écran
        
        if (this.direction == "S") {
     	   posBodyX -= 1;
     	   posTeteX -= 1;
     	   this.setPosBody(new Position(posBodyX, posBodyY));
     	   this.setPosTete(new Position(posTeteX, posTeteY));
        }
        else if (this.direction == "E") {
     	   posBodyY -= 1;
     	   posTeteY -= 1;
     	   this.setPosBody(new Position(posBodyX, posBodyY));
     	   this.setPosTete(new Position(posTeteX, posTeteY));
        }
        else if (this.direction == "O") {
     	   posBodyY += 1;
     	   posTeteY += 1;
     	   this.setPosBody(new Position(posBodyX, posBodyY));
     	   this.setPosTete(new Position(posTeteX, posTeteY));
        }
        else if (this.direction == "N") {
     	   posBodyX += 1;
     	   posTeteX +=1;
     	   this.setPosBody(new Position(posBodyX, posBodyY));
     	   this.setPosTete(new Position(posTeteX, posTeteY));
        }

    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#left()
     */
    @Override
    protected void left() {
        int posTeteX = this.getPosTete().getX();
        int posTeteY = this.getPosTete().getY();
        
        if (this.direction == "N") {
           posTeteY -= 1;
     	   posTeteX += 1;
     	   this.setPosTete(new Position(posTeteX, posTeteY));
     	   this.direction = "O";
        }
        else if (this.direction == "S") {
           posTeteY += 1;
      	   posTeteX -= 1;
      	   this.setPosTete(new Position(posTeteX, posTeteY));
      	   this.direction = "E";	
        }
        else if (this.direction == "E") {
           posTeteY -= 1;
      	   posTeteX -= 1;
      	   this.setPosTete(new Position(posTeteX, posTeteY));
      	   this.direction = "N";
        }
        else if (this.direction == "O") {
           posTeteY += 1;
      	   posTeteX += 1;
      	   this.setPosTete(new Position(posTeteX, posTeteY));
      	   this.direction = "S";
        }
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#right()
     */
    @Override
    protected void right() {
        int posTeteX = this.getPosTete().getX();
        int posTeteY = this.getPosTete().getY();
        
        if (this.direction == "N") {
           posTeteY += 1;
     	   posTeteX += 1;
     	   this.setPosTete(new Position(posTeteX, posTeteY));
     	   this.direction = "E";
        }
        else if (this.direction == "S") {
           posTeteY -= 1;
      	   posTeteX -= 1;
      	   this.setPosTete(new Position(posTeteX, posTeteY));
      	   this.direction = "O";	
        }
        else if (this.direction == "E") {
           posTeteY -= 1;
      	   posTeteX += 1;
      	   this.setPosTete(new Position(posTeteX, posTeteY));
      	   this.direction = "S";
        }
        else if (this.direction == "O") {
           posTeteY += 1;
      	   posTeteX -= 1;
      	   this.setPosTete(new Position(posTeteX, posTeteY));
      	   this.direction = "N";
        }
    }
}
