package hello.advanced.trace;

public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs;
    private String Message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String Message) {
        this.traceId = traceId;
        this.Message = Message;
        this.startTimeMs = startTimeMs;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return Message;
    }
}
