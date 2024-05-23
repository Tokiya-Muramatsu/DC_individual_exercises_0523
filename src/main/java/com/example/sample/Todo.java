package com.example.sample;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="contact")
public class Todo {

	public Todo (String title, String email, String description) {
		super();
		this.title = title;
		this.email = email;
		this.description = description;

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	 @NotBlank(message = "名前を入力してください")
	private String title;
	
	 @NotBlank(message = "メールアドレスを入力してください")
	 @Email(message = "正しい形式のメールアドレスを入力してください")
	private String email;
	
	 @NotBlank(message = "お問い合わせ内容を入力してください")
	 @Size(max = 1000, message = "お問い合わせ内容は1000文字以内で入力してください")
	private String description;
	

}
