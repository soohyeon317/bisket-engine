package com.bisket.engine.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "discriminator_type")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"open_service_id","open_autonomous_body_code","management_code"}
                )
        }
)
@EqualsAndHashCode(callSuper = true, exclude = {"id"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Business extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String openServiceName;
    @Column(name = "open_service_id", nullable = false)
    private String openServiceId;
    @Column(name = "open_autonomous_body_code", nullable = false)
    private String openAutonomousBodyCode;
    @Column(name = "management_code", nullable = false)
    private String managementCode;
    private String licensingDate;
    private String licensingCancelDate;
    private String businessStatusCode;
    private String businessStatusName;
    private String detailedBusinessStatusCode;
    private String detailedBusinessStatusName;
    private String closeDate;
    private String idleStartDate;
    private String idleEndDate;
    private String reopenDate;
    private String sitePhoneNumber;
    private String siteArea;
    private String sitePostCode;
    @Column(columnDefinition = "TEXT")
    private String siteFullAddress;
    private String roadNamePostCode;
    @Column(columnDefinition = "TEXT")
    private String roadNameFullAddress;
    private String businessPlaceName;
    private String lastModificationTime;
    private String dataUpdateClassification;
    private String dataUpdateDate;
    private String businessTypeClassificationName;
    private String xCoordinate;
    private String yCoordinate;
}
