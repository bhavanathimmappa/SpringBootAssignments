package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ChatHistory")
public class Greeting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private String content;
    

    public Greeting() {
    }
    
    public Greeting(String content) {
        this.content = content;
    }
  
    public String getContent() {
        return content;
    }

}