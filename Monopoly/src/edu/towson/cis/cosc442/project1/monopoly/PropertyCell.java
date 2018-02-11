package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyCell.
 */
public class PropertyCell extends Cell {
	
	/** The color group. */
	private String colorGroup;
	
	/** The house price. */
	private int housePrice;
	
	/** The num houses. */
	private int numHouses;
	
	/** The rent. */
	private int rent;
	
	/** The sell price. */
	private int sellPrice;

	/**
	 * Gets the color group.
	 *
	 * @return the color group
	 */
	public String getColorGroup() {
		return colorGroup;
	}

	/**
	 * Gets the house price.
	 *
	 * @return the house price
	 */
	public int getHousePrice() {
		return housePrice;
	}

	/**
	 * Gets the num houses.
	 *
	 * @return the num houses
	 */
	public int getNumHouses() {
		return numHouses;
	}
    
    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.Cell#getPrice()
     */
    public int getPrice() {
		return sellPrice;
	}

	/**
	 * Gets the rent.
	 *
	 * @return the rent
	 */
	public int getRent() {
		int rentToCharge = rent;
		String [] monopolies = owner.getMonopolies();
		for(int i = 0; i < monopolies.length; i++) {
			if(monopolies[i].equals(colorGroup)) {
				rentToCharge = rent * 2;
			}
		}
		if(numHouses > 0) {
			rentToCharge = rent * (numHouses + 1);
		}
		return rentToCharge;
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.Cell#playAction()
	 */
	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(owner != currentPlayer) {
				currentPlayer.payRentTo(owner, getRent());
			}
		}
	}

	/**
	 * Sets the color group.
	 *
	 * @param colorGroup the new color group
	 */
	public void setColorGroup(String colorGroup) {
		this.colorGroup = colorGroup;
	}

	/**
	 * Sets the house price.
	 *
	 * @param housePrice the new house price
	 */
	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	/**
	 * Sets the num houses.
	 *
	 * @param numHouses the new num houses
	 */
	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}

	/**
	 * Sets the price.
	 *
	 * @param sellPrice the new price
	 */
	public void setPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	/**
	 * Sets the rent.
	 *
	 * @param rent the new rent
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}
}