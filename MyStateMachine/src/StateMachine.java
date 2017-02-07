
public class StateMachine {
	
	private static int k = 0;
	private Status state;
	
	public enum Status implements StateMachineInterface {
		ALPHA {
			private int count = 0;

			@Override
			public Status stepNext() {
				return BETA;
			}

			@Override
			public void printStatus() {
				System.out.printf("ALPHA\tVALORE DI K: %d\tNUMERO DI PASSAGGI: %d\n", k, count);
			}

			public void addCount() {
				count++;
			}
		},
		BETA {
			private int count = 0;

			@Override
			public Status stepNext() {
				return (k < 5) ? ALPHA : GAMMA;
			}

			@Override
			public void printStatus() {
				System.out.printf("BETA\tVALORE DI K: %d\tNUMERO DI PASSAGGI: %d\n", k, count);
			}
			public void addCount() {
				count++;
			}
		},
		DELTA {
			private int count = 0;

			@Override
			public Status stepNext() {
				return BETA;
			}

			@Override
			public void printStatus() {
				System.out.printf("DELTA\tVALORE DI K: %d\tNUMERO DI PASSAGGI: %d\n", k, count);
			}
			public void addCount() {
				count++;
			}
		},
		GAMMA {
			private int count = 0;

			@Override
			public Status stepNext() {
				return (k > 100) ? OMEGA : DELTA;
			}

			@Override
			public void printStatus() {
				System.out.printf("GAMMA\tVALORE DI K: %d\tNUMERO DI PASSAGGI: %d\n", k, count);
			}

			public void addCount() {
				count++;
			}

		},
		OMEGA {
			private int count = 0;

			@Override
			public Status stepNext() {
				return ALPHA;
			}

			@Override
			public void printStatus() {
				System.out.printf("OMEGA\tVALORE DI K: %d\tNUMERO DI PASSAGGI: %d\n", k, count);
			}
			public void addCount() {
				count++;
			}
		};
//		
//		@Override
//		public int get() {
//			return k;
//		}		
	}
	
	public void setter(int k) {
		this.k = k;
	}
	
	public StateMachine(int choice) {
		setStatus(choice);
	}

	public void setStatus(int choice) {
		switch(choice) {
		case 1: this.state = Status.ALPHA; break;
		case 2: this.state = Status.BETA; break;
		case 3: this.state = Status.DELTA; break;
		case 4: this.state = Status.GAMMA; break;
		case 5: this.state = Status.OMEGA; break;
		}
	}
	
	public void run(int k) {
		setter(k);
		System.out.println("STATO CORRENTE:");
		state.addCount();
		state.printStatus();
		state = state.stepNext();
		System.out.println("NUOVO STATO:");
		state.addCount();
		state.printStatus();
	}
	

}
