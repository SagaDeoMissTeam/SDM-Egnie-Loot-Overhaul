package net.sdm.sdm_rpg.core.logger;

public interface ISDMLogger {
    void sendInfo(Object message);
    void sendDebug(Object message);
    void sendError(Object message);
    void sendMessage(Object message);

    void send(Object message);

    void sendWarn(Object message);
}
