// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.operator_interface;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** Class for controlling the robot with one Xbox controller and custom operator controller. */
public class CompetitionControls implements OperatorInterface {
  private final XboxController driverJoystick;
  private final CommandJoystick operatorJoystick;
  private final Trigger[] operatorJoystickButtons;

  public CompetitionControls(int driverPort, int operatorPort) {
    driverJoystick = new XboxController(driverPort);
    operatorJoystick = new CommandJoystick(operatorPort);

    // buttons use 1-based indexing such that the index matches the button number; leave index 0 set
    // to null
    this.operatorJoystickButtons = new Trigger[15];

    for (int i = 1; i < operatorJoystickButtons.length; i++) {
      operatorJoystickButtons[i] = operatorJoystick.button(i);
    }
  }

  public double getTranslateX() {
    return -driverJoystick.getLeftY();
  }

  @Override
  public double getTranslateY() {
    return -driverJoystick.getLeftX();
  }

  @Override
  public double getRotate() {
    return -driverJoystick.getRightX();
  }

  @Override
  public Trigger getFieldRelativeButton() {
    return new Trigger(driverJoystick::getBButton);
  }

  @Override
  public Trigger getResetGyroButton() {
    return new Trigger(driverJoystick::getBackButton);
  }

  @Override
  public Trigger getXStanceButton() {
    return new Trigger(driverJoystick::getYButton);
  }

  @Override
  public Trigger getTestButton() {
    return new Trigger(driverJoystick::getAButton);
  }

  @Override
  public Trigger getSpeedOverrideR() {
    return new Trigger(driverJoystick::getRightBumper);
  }

  @Override
  public Trigger getAutoTurnNorth() {
    return new Trigger(driverJoystick::getLeftStickButton);
  }

  @Override
  public Trigger getAutoTurnSouth() {
    return new Trigger(driverJoystick::getRightStickButton);
  }

  @Override
  public Trigger getSpeedOverrideL() {
    return new Trigger(driverJoystick::getLeftBumper);
  }

  @Override
  public Trigger getMoveToHigh() {
    return operatorJoystick.button(1);
  }

  @Override
  public Trigger getMoveToMid() {
    return operatorJoystick.button(2);
  }

  @Override
  public Trigger getMoveToLow() {
    return operatorJoystick.button(3);
  }

  @Override
  public Trigger getMoveToPickup() {
    return operatorJoystick.button(4);
  }

  @Override
  public Trigger getCloseButton() {
    // return new Trigger(operatorJoystickButtons[6]);
    return new Trigger(operatorJoystick.button(5));
  }

  @Override
  public Trigger getOpenButton() {
    return new Trigger(operatorJoystick.button(6));
  }

  @Override
  public Trigger getSafetyStop() {
    return operatorJoystick.button(7);
  }

  @Override
  public Trigger getOpBut8() {
    return operatorJoystick.button(8);
  }

  @Override
  public Trigger getHighScoreButton() {
    return operatorJoystick.button(9);
  }

  @Override
  public Trigger getMidScoreButton() {
    return operatorJoystick.button(10);
  }

  @Override
  public boolean getPickupLocation() {
    return operatorJoystick.button(11).getAsBoolean();
  }

  @Override
  public boolean getGamePieceType() {
    return !operatorJoystick.button(13).getAsBoolean();
  }
}
