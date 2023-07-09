package fscl.project.api.events;

import fscl.core.domain.CodeFormat;
import fscl.core.domain.ProjectCode;
import fscl.messaging.events.DomainEvent;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class ProjectEvent implements DomainEvent {
	
	public final CodeFormat functionFormat;
	public final CodeFormat locationFormat;
	public final CodeFormat componentFormat;

	@NonNull private final Type type;
	@NonNull private final String projectCode;
		
	public enum Type { CREATED,	UPDATE, DELETED	}

	/*
	@Builder
	protected ProjectEvent(
			Type t,
			String projectCode,
			CodeFormat functionFormat,
			CodeFormat locationFormat,
			CodeFormat componentFormat) {
		this.type = t;
		this.projectCode = projectCode;
		this.functionFormat = functionFormat;
		this.locationFormat = locationFormat;
		this.componentFormat = componentFormat;
	}
	*/

	public static ProjectEvent created(
		ProjectCode projectCode,
		CodeFormat functionFormat,
		CodeFormat locationFormat,
		CodeFormat componentFormat
		) {
		
		return ProjectEvent.builder()
				.functionFormat(functionFormat)
				.locationFormat(locationFormat)
				.componentFormat(componentFormat)
				.projectCode(projectCode.toString())
				.type(Type.CREATED)
				.build();
	}

	public static ProjectEvent update(
			ProjectCode projectCode,
			CodeFormat functionFormat,
			CodeFormat locationFormat,
			CodeFormat componentFormat
	) {

		return ProjectEvent.builder()
				.functionFormat(functionFormat)
				.locationFormat(locationFormat)
				.componentFormat(componentFormat)
				.projectCode(projectCode.toString())
				.type(Type.UPDATE)
				.build();
	}

	public static ProjectEvent deleted(ProjectCode projectCode) {
		return ProjectEvent.builder()
				.projectCode(projectCode.toString())
				.type(Type.DELETED)
				.build();
	}
	
}
