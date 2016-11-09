import java.util.Random;

public class JarLogic {
private int mAnswer;
private int mMisses;
private static int mMaxAmount;
private static String mItemName;
private int mActualNumber;
	public JarLogic() {
		mAnswer=0;
		mMisses=0;
		mMaxAmount=0;
		mItemName="";
		mActualNumber=0;
	}
	//-----------------Setters and Getters--------------- this was not teached but i knew it before i started the treehouse course
	Random random = new Random();

	public int getmActualNumber() {
		return mActualNumber;
	}

	public void setmActualNumber(int mActualNumber) {
		this.mActualNumber = mActualNumber;
	}
	public int getmAnswer() {
		return mAnswer;
	}
	
	public int getmMisses() {
		return mMisses;
	}
	
	
	public static int getmMaxAmount() {
		return mMaxAmount;
	}
	public void setmMaxAmount(int mMaxAmount) {
		this.mMaxAmount = mMaxAmount;
	}
	public static String getmItemName() {
		return mItemName;
	}
	public void setmItemName(String mItemName) {
		this.mItemName = mItemName;
	}
	//-------------------Main methods----------
	public void fill(){//you fill the jar with at least 1 item
		int someNumber=0;
		while(someNumber==0){
		someNumber = random.nextInt(mMaxAmount);
		}
    System.out.printf("Filling up the Jar randomly with %s...\n ",getmItemName());
		mAnswer=someNumber;
	}
	
	public int validateAmount(int num){//if there is no items there is an error
		if (num<=0){
			throw new IllegalArgumentException("The jar can't be empty!");
		}
		return num;
	}
	
	public int validateGuess(String text){
		int newNumber=0;
		if (text.matches("-[1-9]+")){//if there is any negative guess there is an error
			throw new IllegalArgumentException("You can't guess negative numbers");
		}
		
		if (!text.matches("[0-9]+")){//if there is a letter there is an error
			throw new IllegalArgumentException("You can't guess with letters");
		}
		if(text.matches("[0]")){// if anyone guesses 0 there is an error
			throw new IllegalArgumentException("The jar is not empty!");
		}
		
		if (text.matches("[1-9]+")){
			newNumber=Integer.parseInt(text);
			if(newNumber>mMaxAmount){//over-guess error
				throw new IllegalArgumentException("Your guess must be less than the maximum fill amount");
			}
		}
		
		return newNumber;
	}
	
	public boolean applyGuess(String text){
		int newNumber;
		newNumber = validateGuess(text);
		setmActualNumber(newNumber);//the mActualNumber variable was used to make the hint prompter 
		  boolean isAMatch = (mAnswer == mActualNumber);
		  if(isAMatch){
        mMisses++;
		  		  return isAMatch;
		   }else {
		     mMisses++;//stacks your misses
		     	return isAMatch;
		  }}
		
	}
	
	