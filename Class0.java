import muvium.compatibility.arduino.*;

public class Class0 extends Arduino {


/* 
	EJERCICIO:
	Realice un contador de un decimal que cuente de 0 a 9 ascendentemente y luego descendentemente
	9 a 0 pero que solo muestre los numeros pares y que con el Boton se pause el contador, y al
	soltar el boton continue la secuencia
*/
	int pinA = 8;
	int pinB = 7;
	int pinC = 9;
	int pinD = 10;
	int pinE = 11;
	int pinF = 12;
	int pinG = 13;
	int pinBoton = 2; 
	int status;

	int[] pins = {pinA, pinB, pinC, pinD, pinE, pinF, pinG};

	boolean[][] num = {
		{true, true, true, true, true, true, false},   // 0
		{false, true, true, false, false, false, false}, // 1
		{true, true, false, true, true, false, true},   // 2
		{true, true, true, true, false, false, true},   // 3
		{false, true, true, false, false, true, true},  // 4
		{true, false, true, true, false, true, true},   // 5
		{true, false, true, true, true, true, true},    // 6
		{true, true, true, false, false, false, false}, // 7
		{true, true, true, true, true, true, true},     // 8
		{true, true, true, true, false, true, true}     // 9
		};

	public void setup() {

		pinMode(pinA, OUTPUT);
		pinMode(pinB, OUTPUT);
		pinMode(pinC, OUTPUT);
		pinMode(pinD, OUTPUT);
		pinMode(pinE, OUTPUT);
		pinMode(pinF, OUTPUT);
		pinMode(pinG, OUTPUT);
		pinMode(pinBoton, INPUT); 
	}

	public void loop() {
		numberAsc(1000);
		numberDesc(1000);
	}

	public void displayNumber(int number) {
		for (int i = 0; i < 7; i++) {
			digitalWrite(pins[i], num[number][i] ? HIGH : LOW);
		}
	}

	public void numberAsc(int ms) {
		for (int i = 0; i < num.length; i++) {
			if (i % 2 == 0) {
				displayNumber(i);
				delayWithPause(ms);
			}
		}
	}

	public void numberDesc(int ms) {
		for (int i = 9; i >= 0; i--) {
			if (i % 2 == 0) {
				displayNumber(i);
				delayWithPause(ms);
			}
		}
	}

	public void delayWithPause(int ms) {
		long pauseEnd = millis() + ms;
		while (millis() < pauseEnd) {
			if (digitalRead(pinBoton) == HIGH) { 
				while (digitalRead(pinBoton) == HIGH) {
					
				}
				pauseEnd = millis() + (pauseEnd - millis()); 
			}
		}
	}
}

