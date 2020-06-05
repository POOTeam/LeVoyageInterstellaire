package fr.emac.gipsi.gsi.animation;

public class AnimationSerpent extends AbstractAnimation{

	public AnimationSerpent() {
		
	}
	
	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt=copyScreen(ecranDeb);
		for(int j=0;j<ecranInt.getLigMax()+1;j++) {
			if(j%2==0){				
				for(int i=0;i<ecranInt.getColMax()+1;i++){
				ecranInt.updateColorByXY(i, j, ecranFin.getColorByXY(i, j));
				showScreen(ecranInt);
				this.wait(20);
				}
			}
			
			else{
				for(int i=0;i<ecranInt.getColMax()+1;i++){
					ecranInt.updateColorByXY(ecranInt.getColMax()-i, j, ecranFin.getColorByXY(ecranInt.getColMax()-i, j));
					showScreen(ecranInt);
					this.wait(20);
					
					}
			}
		}
		this.showScreen(ecranInt);
	}
}