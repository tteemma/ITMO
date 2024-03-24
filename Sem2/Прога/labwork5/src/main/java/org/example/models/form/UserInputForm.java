package org.example.models.form;

import org.example.exeptions.IllegalArgument;
import org.example.exeptions.InvalidForm;

/**
 * Абстрактный класс для форм пользовательского ввода
 */
public abstract class UserInputForm<T>{
    public abstract T create() throws InvalidForm, IllegalArgument;
}
