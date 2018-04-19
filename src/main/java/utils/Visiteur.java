package utils;

import user.User;

public abstract class Visiteur {


	public void visit(Visitable v){
		v.accept(this);
	}

	public abstract void visit(User u);
	
}
