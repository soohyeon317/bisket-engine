package com.bisket.engine.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "discriminator_type")
@EqualsAndHashCode(callSuper = true, exclude = {"id"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Business extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String managementCode;
    @Column(nullable = false)
    private String openServiceId;
    @Column(nullable = false)
    private String openAutonomousEntityCode;
    private String openServiceName;
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
    private String siteFullAddress;
    private String roadNamePostCode;
    private String roadNameFullAddress;
    private String businessPlaceName;
    private String lastModificationTime;
    private String dataUpdateClassification;
    private String dataUpdateDate;
    private String businessConditionsName;
    private String xCoordinate;
    private String yCoordinate;
}
