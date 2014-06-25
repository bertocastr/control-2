package es.unileon.ulebank.handler;

import es.unileon.ulebank.exceptions.MalformedHandlerException;

public class AccountHandler implements Handler {

	private String numberAccount;

	/**
	 * Creates the handler of the account
	 * 
	 * @param number
	 * @throws MalformedHandlerException
	 */
	public AccountHandler(String number) throws MalformedHandlerException {
		if (number.length() >= 0) {

			if (number.length() == 4) {
				this.numberAccount = number;
			} else {
				if (number.length() < 4) {
					this.numberAccount = number;
					while (numberAccount.length() <= 4) {
						numberAccount = 0 + numberAccount;
					}
				} else {
					throw new MalformedHandlerException(
							"The idOffice is malformed");
				}
			}
		} else {
			throw new MalformedHandlerException(
					"The idOffice has to be a positive number");
		}
	}

	@Override
	public String toString() {
		return numberAccount;
	}

	public int compareTo(Handler another) {
		return this.toString().compareTo(another.toString());
	}

}
