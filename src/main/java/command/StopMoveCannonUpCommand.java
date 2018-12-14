package command;

import proxy.IGameModel;

public class StopMoveCannonUpCommand extends AbsGameCommand
{
    public StopMoveCannonUpCommand(IGameModel subject)
    {
        super(subject);
    }

    @Override
    public void execute()
    {
        this.subject.stopMoveCannonUp();
    }
}