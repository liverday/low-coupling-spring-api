package com.liverday.demo.application.application.usecases;

public interface UseCase<IN, OUT> {
  OUT execute(IN input);
}
