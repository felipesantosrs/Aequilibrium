package task_2;

public class Result {
	public Result(Status status, Transformer transformer) {
		super();
		this.status = status;
		this.transformer = transformer;
	}

	private Status status;

	private Transformer transformer;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Transformer getTransformer() {
		return transformer;
	}

	public void setTransformer(Transformer transformer) {
		this.transformer = transformer;
	}
}
