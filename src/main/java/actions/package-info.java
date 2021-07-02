/**
 * <p>
 *     This package provides the different actions that will performed after
 *     every command triggering.
 *     For example: {@link actions.GenerateAction} GenerateAction will generate
 *     the appropriate files in order to generate a specific resource
 *     like Entity, Service, etc ....
 *
 *     All Different Actions will be inherited from the {@link actions.AbstractAction} AbstractAction and override
 *     the execute method each one for its specific reason.
 * </p>
 * <p>
 *     Use {@link actions.GenerateAction} GenerateAction to generate different resources like APIRest and GraphQL
 *     resources.
 * </p>
 * <p>
 *     Unlike {@link actions.GenerateAction} GenerateAction, the {@link actions.DeleteAction} DeleteAction is used
 *     to delete different resources.
 * </p>
 */
package actions;