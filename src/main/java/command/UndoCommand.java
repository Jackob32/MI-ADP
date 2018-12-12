package command;

import proxy.IGameModel;

public class UndoCommand extends AbsGameCommand
{
    public UndoCommand(IGameModel subject)
    {
        super(subject);
    }

    @Override
    public void execute()
    {
        this.subject.undoLastCmd();
    }
}