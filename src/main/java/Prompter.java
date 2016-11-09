import java.util.Scanner;

public class Prompter {
	public static final int CLOSE=5;
private JarLogic mJarLogic;
	public Prompter(JarLogic jarlogic){
	mJarLogic = jarlogic;
			}

Scanner scanInt = new Scanner(System.in);
Scanner scanString= new Scanner(System.in);
	public void WelcomeToTheGame(){
		System.out.println("Welcome to the guessing how many objects a Jar has!");
		System.out.println("You can even enter what things the jar will be filled with");
		System.out.println("Okay lets get Started \n-----------\n");
		
	}

	public void askItemName(){
		System.out.println("Please enter what is your Jar going to be filled with: ");
	mJarLogic.setmItemName(scanString.nextLine());
		}
		
	
	public void askMaxAmount(){
		System.out.printf("Great! now please enter the maximum amount of %s your jar can fit in it: \n",mJarLogic.getmItemName());
		boolean isValid=false;
		while(!isValid)
		try{
		int num=scanInt.nextInt();
		mJarLogic.validateAmount(num);
		isValid=true;
		mJarLogic.setmMaxAmount(num);
		
		}catch(IllegalArgumentException iae){
			System.out.printf("%s try again\n",iae.getMessage());
		}
	
		}
	

	public void promptForGuess(){
		String text="";
		int counter=-1;//this counter lets you prompt hints only when there is no error,
		               //neither when the game starts(since it would be illogical)
		boolean isHit=false;
		boolean isValidGuess=false;
		while(! isValidGuess || isHit==false){
			if(counter==-1){
				System.out.println("try your luck and have a guess!:");
				counter=0;
			}else{
				if(counter==0){
				promptForHint();}

				System.out.println("Have another guess: ");
			}	
				text=scanString.nextLine();
			try{
				isHit=mJarLogic.applyGuess(text);
				isValidGuess=true;
				counter=0;
			}catch(IllegalArgumentException iae){
				System.out.printf("%s please try again \n",iae.getMessage());
				counter=1;
			}
		}	
	}
		public void promptMaxAmount(){
		System.out.printf("The jar has a capacity of %d %s\n",JarLogic.getmMaxAmount(),JarLogic.getmItemName());
	}
  
	public void promptForHint(){//gives you a hint
		if((mJarLogic.getmAnswer()-mJarLogic.getmActualNumber())<0){
			if((mJarLogic.getmActualNumber()-mJarLogic.getmAnswer())>=CLOSE){
				System.out.println("you are far away");
				}
			else if((mJarLogic.getmActualNumber()-mJarLogic.getmAnswer())<=CLOSE){
				System.out.println("you are too close");
				}
		}
		else{
		
			if((mJarLogic.getmAnswer()-mJarLogic.getmActualNumber())>=CLOSE){
			System.out.println("you are too far away");
			}
		else if((mJarLogic.getmAnswer()-mJarLogic.getmActualNumber())<=CLOSE){
			System.out.println("you are too close");
			}}
		
		
	}
		
	public void youWin(){//win message
		
		System.out.printf("Congratulations! You figured out the amount of %s there was in the Jar in only %d tries",mJarLogic.getmItemName(),mJarLogic.getmMisses());
		
	}
 
	
	public void play(){//main method that lets you play
		WelcomeToTheGame();
		askItemName();
		askMaxAmount();
    promptMaxAmount();
		mJarLogic.fill();
		promptForGuess();
		youWin();
	
	}

}