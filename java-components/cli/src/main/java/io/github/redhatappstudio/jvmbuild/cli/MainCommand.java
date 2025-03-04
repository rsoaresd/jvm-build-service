package io.github.redhatappstudio.jvmbuild.cli;

import java.io.PrintWriter;

import jakarta.enterprise.inject.Vetoed;

import io.github.redhatappstudio.jvmbuild.cli.artifacts.ArtifactCommand;
import io.github.redhatappstudio.jvmbuild.cli.builds.BuildCommand;
import io.github.redhatappstudio.jvmbuild.cli.rebuilt.RebuiltCommand;
import io.github.redhatappstudio.jvmbuild.cli.settings.SetupCommand;
import jline.console.ConsoleReader;
import picocli.CommandLine;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

@CommandLine.Command(name = "jbs", mixinStandardHelpOptions = true, subcommands = {
        QuitCommand.class,
        BuildCommand.class,
        ArtifactCommand.class,
        RebuiltCommand.class,
        SetupCommand.class
})
@Vetoed
public class MainCommand {
    final ConsoleReader reader;
    final PrintWriter out;

    @Spec
    private CommandSpec spec;

    MainCommand(ConsoleReader reader) {
        this.reader = reader;
        out = new PrintWriter(reader.getOutput());
    }

    public void run() {
        out.println(spec.commandLine().getUsageMessage());
    }

}
